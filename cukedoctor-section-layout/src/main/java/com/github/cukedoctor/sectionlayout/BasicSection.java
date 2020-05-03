package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.util.builder.FeatureBuilder;

import java.util.*;

import static com.github.cukedoctor.util.Constants.SKIP_DOCS;

public class BasicSection implements Section {
    private final Map<String, Section> sectionsByGroup = new HashMap<>();
    private final List<Section> grouplessFeatures = new LinkedList<>();
    private final String id;
    private final String style;
    private final String groupingTagPattern;
    private int order = Integer.MAX_VALUE;
    private Section root;

    public BasicSection(String id) {
        this(id, null);
    }

    public BasicSection(String id, String style) {
        this(id, style, null);
    }

    public BasicSection(String id, String style, String groupingTagPattern) {
        this.id = id;
        this.style = style;
        this.groupingTagPattern = groupingTagPattern;
    }

    @Override
    public Section addFeature(Feature feature) {
        Optional<String> groupId = getGroupId(feature);
        if (groupId.isPresent()) {
            addToGroup(feature, groupId.get());
        } else if (hadRootScenario(feature)) {
            addAsRoot(feature);
        } else {
            addToGroupless(feature);
        }

        updateOrder(feature);
        return this;
    }

    private Optional<String> getGroupId(Feature feature) {
        return groupingTagPattern == null ? Optional.empty() : feature.extractTag(groupingTagPattern);
    }

    private void addToGroup(Feature feature, String groupId) {
        getGroupSection(groupId).addFeature(feature);
    }

    private Section getGroupSection(String groupId) {
        if (sectionsByGroup.containsKey(groupId)) {
            return sectionsByGroup.get(groupId);
        }

        final Section newGroup = new BasicSection(groupId);
        sectionsByGroup.put(groupId, newGroup);
        return newGroup;
    }

    private boolean hadRootScenario(Feature feature) {
        if (!feature.hasScenarios()) {
            return false;
        }

        for (Scenario scenario : feature.getScenarios()) {
            if (scenario.getName().equals("Root")) {
                addSkipDocsTag(scenario);
                return true;
            }
        }

        return false;
    }

    private void addSkipDocsTag(Scenario scenario) {
        if (scenario.hasTags()) {
            scenario.getTags().add(createSkipDocsTag());
            return;
        }

        ArrayList<Tag> tags = new ArrayList<>(1);
        tags.add(createSkipDocsTag());
        scenario.setTags(tags);
    }

    private Tag createSkipDocsTag() {
        return new Tag(SKIP_DOCS);
    }

    private void addAsRoot(Feature feature) {
        root = new FeatureSection(feature);
    }

    private void addToGroupless(Feature feature) {
        grouplessFeatures.add(new FeatureSection(feature));
    }

    private void updateOrder(Feature feature) {
        order = Math.min(order, feature.getOrder());
    }

    @Override
    public String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        if (!hasRoot() && sectionsByGroup.isEmpty() && grouplessFeatures.isEmpty()) return "";

        renderName(docBuilder, i18n, documentAttributes);
        renderChildren(docBuilder, i18n, documentAttributes);

        return docBuilder.toString();
    }

    private boolean hasRoot() {
        return root != null;
    }

    protected boolean shouldRenderSectionName() {
        return true;
    }

    private void renderName(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        if (!shouldRenderSectionName()) return;

        renderStyle(docBuilder);
        renderTitle(docBuilder, i18n, documentAttributes);
    }

    private void renderStyle(CukedoctorDocumentBuilder docBuilder) {
        if (style != null) {
            docBuilder.textLine("[" + style + "]");
        }
    }

    private void renderTitle(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        Section titleSection = getTitleSection(i18n);
        docBuilder.append(titleSection.render(docBuilder.createPeerBuilder(), i18n, documentAttributes)).nestTitle();
    }

    private Section getTitleSection(I18nLoader i18n) {
        if (hasRoot()) return root;

        final String name = getName(i18n);
        return new FeatureSection(FeatureBuilder.instance().name(name).build());
    }

    protected String getName(I18nLoader i18n) {
        return id;
    }

    private void renderChildren(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        for (Section child : getChildren()) {
            docBuilder.append(child.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        }
    }

    private Iterable<Section> getChildren() {
        ArrayList<Section> children = new ArrayList<>(sectionsByGroup.size() + grouplessFeatures.size());
        children.addAll(sectionsByGroup.values());
        children.addAll(grouplessFeatures);
        Collections.sort(children);
        return children;
    }

    @Override
    public int getOrder() {
        return order;
    }
}
