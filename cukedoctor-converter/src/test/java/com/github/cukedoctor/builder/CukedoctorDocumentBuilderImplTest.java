package com.github.cukedoctor.builder;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.junit.Assert.assertEquals;

// With reference to https://asciidoctor.org/docs/user-manual/#sections
@RunWith(JUnit4.class)
public class CukedoctorDocumentBuilderImplTest {
    private final String level0Title = "Document Title (Level 0)";
    private final String level1Title = "Level 1 Section Title";
    private final String level2Title = "Level 2 Section Title";
    private final String level3Title = "Level 3 Section Title";
    private final String level4Title = "Level 4 Section Title";
    private final String level5Title = "Level 5 Section Title";
    private CukedoctorDocumentBuilderImpl builder;

    @Before
    public void before() {
        builder = new CukedoctorDocumentBuilderImpl();
    }


    @Test
    public void shouldConstructAtSpecifiedTitleNestingLevel() {
        builder = createInstanceWithNestingLevel2();
        builder.title("My Title");
        assertDocumentEquals("=== My Title");
    }


    // Rendering named section titles
    @Test
    public void shouldRenderDocumentTitle() {
        builder.documentTitle(level0Title);
        assertDocumentEquals("= " + level0Title + newLine());
    }

    @Test
    public void shouldRenderLevel1SectionTile() {
        builder.sectionTitleLevel1(level1Title);
        assertDocumentEquals("== " + level1Title);
    }

    @Test
    public void shouldRenderLevel2SectionTitle() {
        builder.sectionTitleLevel2(level2Title);
        assertDocumentEquals("=== " + level2Title);
    }

    @Test
    public void shouldRenderLevel3SectionTitle() {
        builder.sectionTitleLevel3(level3Title);
        assertDocumentEquals("==== " + level3Title);
    }

    @Test
    public void shouldRenderLevel4SectionTitle() {
        builder.sectionTitleLevel4(level4Title);
        assertDocumentEquals("===== " + level4Title);
    }

    @Test
    public void shouldRenderLevel5SectionTitle() {
        builder.sectionTitleLevel5(level5Title);
        assertDocumentEquals("====== " + level5Title);
    }


    // Rendering unnamed section titles, allowing the builder to manage the nesting

    @Test
    public void shouldRenderTitleAtLevel0ByDefault() {
        builder.title(level0Title);
        assertDocumentEquals("= " + level0Title + newLine());
    }

    @Test
    public void shouldRenderTitleAtLevel1AfterNestingOnce() {
        builder.title(level0Title).nestTitle()
                .title(level1Title)
                .title("Other " + level1Title);

        assertDocumentEquals(
                "= " + level0Title + newLine() + newLine()
                        + "== " + level1Title + newLine()
                        + "== Other " + level1Title);
    }

    @Test
    public void shouldRenderTitleAtLevel2AfterNestingTwice() {
        builder.title(level0Title).nestTitle()
                .title(level1Title).nestTitle()
                .title(level2Title)
                .title("Other " + level2Title);

        assertDocumentEquals(
                "= " + level0Title + newLine() + newLine()
                        + "== " + level1Title + newLine()
                        + "=== " + level2Title + newLine()
                        + "=== Other " + level2Title);
    }

    @Test
    public void shouldRenderTitleAtLevel3AfterNestingThreeTimes() {
        builder.title(level0Title).nestTitle()
                .title(level1Title).nestTitle()
                .title(level2Title).nestTitle()
                .title(level3Title)
                .title("Other " + level3Title);

        assertDocumentEquals(
                "= " + level0Title + newLine() + newLine()
                        + "== " + level1Title + newLine()
                        + "=== " + level2Title + newLine()
                        + "==== " + level3Title + newLine()
                        + "==== Other " + level3Title);
    }

    @Test
    public void shouldRenderTitleAtLevel4AfterNestingFourTimes() {
        builder.title(level0Title).nestTitle()
                .title(level1Title).nestTitle()
                .title(level2Title).nestTitle()
                .title(level3Title).nestTitle()
                .title(level4Title)
                .title("Other " + level4Title);

        assertDocumentEquals(
                "= " + level0Title + newLine() + newLine()
                        + "== " + level1Title + newLine()
                        + "=== " + level2Title + newLine()
                        + "==== " + level3Title + newLine()
                        + "===== " + level4Title + newLine()
                        + "===== Other " + level4Title);
    }

    @Test
    public void shouldRenderTitleAtLevel5AfterNestingFiveTimes() {
        builder.title(level0Title).nestTitle()
                .title(level1Title).nestTitle()
                .title(level2Title).nestTitle()
                .title(level3Title).nestTitle()
                .title(level4Title).nestTitle()
                .title(level5Title)
                .title("Other " + level5Title);

        assertDocumentEquals(
                "= " + level0Title + newLine() + newLine()
                        + "== " + level1Title + newLine()
                        + "=== " + level2Title + newLine()
                        + "==== " + level3Title + newLine()
                        + "===== " + level4Title + newLine()
                        + "====== " + level5Title + newLine()
                        + "====== Other " + level5Title);
    }

    @Test
    public void shouldRenderTitleAtPreviousLevelAfterPopping() {
        builder.title(level0Title).nestTitle()
                .title(level1Title).nestTitle()
                .title(level2Title).nestTitle()
                .title(level3Title).nestTitle()
                .title(level4Title).nestTitle()
                .title(level5Title).unNestTitle()
                .title("Second " + level4Title).nestTitle()
                .title("Second " + level5Title).unNestTitle()
                .title("Third " + level4Title).unNestTitle()
                .title("Second " + level3Title).unNestTitle()
                .title("Second " + level2Title).unNestTitle()
                .title("Second " + level1Title).unNestTitle()
                .title("Second " + level0Title);

        assertDocumentEquals(
                "= " + level0Title + newLine() + newLine()
                        + "== " + level1Title + newLine()
                        + "=== " + level2Title + newLine()
                        + "==== " + level3Title + newLine()
                        + "===== " + level4Title + newLine()
                        + "====== " + level5Title + newLine()
                        + "===== Second " + level4Title + newLine()
                        + "====== Second " + level5Title + newLine()
                        + "===== Third " + level4Title + newLine()
                        + "==== Second " + level3Title + newLine()
                        + "=== Second " + level2Title + newLine()
                        + "== Second " + level1Title + newLine()
                        + "= Second " + level0Title + newLine());
    }

    @Test(expected = CukedoctorDocumentBuilderImpl.NestingOverflowException.class)
    public void shouldThrowIfNestingBeyondLevel5() {
        builder.nestTitle().nestTitle().nestTitle().nestTitle().nestTitle().nestTitle();
    }

    @Test(expected = CukedoctorDocumentBuilderImpl.NestingUnderflowException.class)
    public void shouldThrowIfUnNestingBeyondInitialLevel() {
        builder = createInstanceWithNestingLevel2();
        builder.unNestTitle();
    }

    @Test
    public void shouldRenderTitleAndAdvanceToNextNestLevel() {
        builder.titleThenNest(level0Title).title(level1Title);
        assertDocumentEquals(
                "= " + level0Title + newLine() + newLine()
                        + "== " + level1Title);
    }


    @Test
    public void nestedBuilderShouldRenderAtLevel2IfParentWasAtLevel1() {
        // Assert root builder is at level 0
        assertEquals("= My Level 0 Title" + newLine() + newLine(), builder.title("My Level 0 Title").toString());

        // Assert child builder is at level 1
        CukedoctorDocumentBuilder child = builder.createNestedBuilder();
        assertEquals("== My Level 1 Title" + newLine(), child.title("My Level 1 Title").toString());

        // Assert root buidler remains at level 0
        assertEquals(
                "= My Level 0 Title" + newLine() + newLine()
                        + "= My Other Level 0 Title" + newLine() + newLine(),
                builder.title("My Other Level 0 Title").toString());
    }

    @Test(expected = CukedoctorDocumentBuilderImpl.NestingOverflowException.class)
    public void createNestedBuilderShouldThrowIfParentIsAtMaximumNestingDepth() {
        builder.createNestedBuilder().createNestedBuilder().createNestedBuilder().createNestedBuilder().createNestedBuilder().createNestedBuilder();
    }


    @Test
    public void peerBuilderShouldRenderAtSameLevelAsParent() {
        CukedoctorDocumentBuilder parent = builder.createNestedBuilder();
        assertEquals("== Parent Level 1 Title" + newLine(), parent.title("Parent Level 1 Title").toString());

        CukedoctorDocumentBuilder peer = parent.createPeerBuilder();
        assertEquals("== Peer Level 1 Title" + newLine(), peer.title("Peer Level 1 Title").toString());
    }


    @Test
    public void clearShouldResetNestingLevel() {
        builder = createInstanceWithNestingLevel2();
        builder.nestTitle().nestTitle().title("My Title");
        builder.clear();
        builder.title("My Title");

        assertDocumentEquals("=== My Title");
    }

    @Test
    public void clearShouldResetAttributesBuilder() {
        builder.attributes().stem("asciimath");
        builder.clear();
        assertEquals("", builder.attributes().asciiDocBuilder().toString());
    }


    private CukedoctorDocumentBuilderImpl createInstanceWithNestingLevel2() {
        return (CukedoctorDocumentBuilderImpl) new CukedoctorDocumentBuilderImpl().createNestedBuilder().createNestedBuilder();
    }

    private void assertDocumentEquals(String content) {
        assertEquals(content + newLine(), builder.toString());
    }
}
