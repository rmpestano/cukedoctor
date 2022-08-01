package com.github.cukedoctor.renderer;

import static com.github.cukedoctor.api.CukedoctorDocumentBuilder.Factory.newInstance;
import static com.github.cukedoctor.util.Assert.hasElements;
import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.notNull;
import static com.github.cukedoctor.util.Constants.Markup.exampleBlock;
import static com.github.cukedoctor.util.Constants.Markup.listing;
import static com.github.cukedoctor.util.Constants.Markup.table;
import static com.github.cukedoctor.util.Constants.Markup.tableCol;
import static com.github.cukedoctor.util.Constants.newLine;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Comment;
import com.github.cukedoctor.api.model.DocString;
import com.github.cukedoctor.api.model.Embedding;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Output;
import com.github.cukedoctor.api.model.Result;
import com.github.cukedoctor.api.model.Row;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Status;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.spi.StepsRenderer;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.Formatter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/** Created by pestano on 28/02/16. */
public class CukedoctorStepsRenderer extends AbstractBaseRenderer implements StepsRenderer {

  public CukedoctorStepsRenderer() {}

  public CukedoctorStepsRenderer(CukedoctorConfig cukedoctorConfig) {
    this.cukedoctorConfig = cukedoctorConfig;
  }

  @Override
  public String renderSteps(List<Step> steps, Scenario scenario, Feature feature) {
    docBuilder.clear();

    docBuilder.textLine("==========");
    for (Step step : steps) {
      docBuilder.append(step.getKeyword(), "::", newLine());
      docBuilder.append(step.getName() + " ", Status.getStatusIcon(step.getStatus()));
      if (!cukedoctorConfig.isHideStepTime()) {
        docBuilder.append(renderStepTime(step.getResult()));
      }

      docBuilder.append(renderStepTable(step));

      if (notNull(step.getDocString()) && hasText(step.getDocString().getValue())) {
        if (step.getDocString().isDiscrete()
            || step.hasDiscreteComment()
            || isDiscrete(scenario)
            || isDiscrete(feature)) {
          // discrete step renders inside a sidebar block and has [discrete] class on every line
          renderDiscreteSidebarBlock(step.getDocString());

        } else {
          renderListingBlock(step.getDocString());
        }
      }

      if (step.getResult() != null
          && !Status.passed.equals(step.getStatus())
          && step.getResult().getErrorMessage() != null) {
        docBuilder.append(newLine(), "IMPORTANT: ", step.getResult().getErrorMessage(), newLine());
      }
      renderOutput(step);
      renderAttachments(step);
      enrichStep(step);
    }
    docBuilder.textLine("==========").newLine();

    return docBuilder.toString();
  }

  private boolean isDiscrete(Scenario scenario) {
    if (!scenario.hasTags()) return false;
    return isDiscrete(scenario.getTags());
  }

  private boolean isDiscrete(Feature feature) {
    if (!feature.hasTags()) return false;
    return isDiscrete(feature.getTags());
  }

  private boolean isDiscrete(Iterable<Tag> tags) {
    for (Tag tag : tags) {
      if (tag.isDiscrete()) return true;
    }

    return false;
  }

  void renderOutput(Step step) {
    if (step.hasOutput()) {
      docBuilder.textLine(listing());
      for (Output output : step.getOutput()) {
        docBuilder.textLine(output.getValue());
      }
      docBuilder.textLine(listing());
    }
  }

  private void renderAttachments(Step step) {
    if (!step.hasEmbeddings()) {
      return;
    }

    // HACK to pass an int by ref
    AtomicInteger notNamedCount = new AtomicInteger(1);
    for (Embedding attachment : step.getEmbeddings()) {
      if (!shouldRenderAttachment(attachment)) {
        continue;
      }
      renderAttachmentTitle(attachment, notNamedCount);
      renderAttachmentContent(attachment);
    }
  }

  private boolean shouldRenderAttachment(Embedding attachment) {
    return hasText(attachment.getMimeType()) && attachment.getMimeType().startsWith("text/");
  }

  private void renderAttachmentContent(Embedding attachment) {
    docBuilder.textLine("[%collapsible]");
    docBuilder.textLine(exampleBlock());

    if (hasText(attachment.getData())) {
      docBuilder.textLine(getAttachmentContent(attachment));
    }

    docBuilder.textLine(exampleBlock());
  }

  private String getAttachmentContent(Embedding attachment) {
    // HACK When using the JSON formatter, there is no way to tell if the attachment has been
    // base64-encoded
    // or not. In this implementation, we assume that anything that could be base64-encoded actually
    // is.
    //
    // The new message formatter
    // (https://github.com/cucumber/cucumber/blob/master/messages/messages.proto)
    // provides an explicit content_encoding field to make this unambiguous. Until we adopt it, the
    // hack
    // remains.

    // Additionally, we assume UTF-8 encoding. An enterprising contributor may wish to parse the
    // mime type
    // to check if a charset parameter has been specified.
    try {
      return new String(Base64.getDecoder().decode(attachment.getData()), StandardCharsets.UTF_8);
    } catch (IllegalArgumentException e) {
      return attachment.getData();
    }
  }

  private void renderAttachmentTitle(Embedding attachment, AtomicInteger notNamedCount) {
    docBuilder.newLine();
    docBuilder.append(".");
    docBuilder.textLine(getAttachmentTitle(attachment, notNamedCount));
  }

  private String getAttachmentTitle(Embedding attachment, AtomicInteger notNamedCount) {
    if (hasText(attachment.getName())) {
      return attachment.getName();
    }

    return "Attachment " + notNamedCount.getAndIncrement();
  }

  private void renderListingBlock(DocString docString) {
    if (docString.getContentType() != null && !docString.getContentType().equals("")) {
      docBuilder.append("[source,", docString.getContentType(), "]", newLine());
    }
    docBuilder.append(listing(), newLine(), newLine());
    docBuilder.append(docString.getValue().replace("\n", newLine()));
    docBuilder.append(newLine(), newLine(), listing(), newLine());
  }

  private void renderDiscreteSidebarBlock(DocString docString) {
    docBuilder.append("******", newLine(), newLine());

    String[] lines =
        docString
            .getValue()
            .replaceAll("\\*\\*\\*\\*", "*****")
            .replace(exampleBlock(), exampleBlock() + "=")
            .split("\\n");

    // every line that starts with \n and not contains pipe(|) will have discrete class
    // pipe is skipped because it denotes table cells in asciidoc and putting
    // a discrete class will break tables
    // also includes are skipped
    // regex try:("^(?=.*^\\n)(?!\\n\\|).*$")
    boolean isListing = false; // control if line is inside a listing
    boolean isTable = false; // control if line is inside a table

    for (String line : lines) {

      if (!isListing) {
        line = line.replace("\r", "");
      }
      if (isListing) {
        if (line.contains("----")) {
          // end listing
          isListing = false;
        }
        docBuilder.textLine(line);
        continue;
      }

      if (line.contains("----")) {
        isListing = true;
        docBuilder.textLine(line);
        continue;
      }

      // do not add discrete to callouts
      if (line.startsWith("<") && line.endsWith(">")) {
        docBuilder.textLine(line);
        continue;
      }
      // do not add discrete to complex blocks otherwise it will produce invalid markup like below:
      // [discrete] [IMPORTANT] [discrete] ======
      if (line.startsWith("======")) {
        docBuilder.textLine(line);
        continue;
      }

      if (isTable) {
        // skip discrete class when within a table
        docBuilder.textLine(line);
        if (line.contains(table())) {
          isTable = false; // end table
        }
        continue;
      }

      // skips discrete class for table col (it must add discrete to table itself)
      if (line.contains(table())) {
        isTable = true;
      }
      // not inside a table neither listing then add discrete class to line
      docBuilder.textLine(Constants.DISCRETE).textLine(line);
    }
    docBuilder.append(newLine(), newLine(), "******", newLine());
  }

  private void enrichStep(Step step) {
    if (step != null && step.hasComments()) {
      int numComments = step.getComments().size();
      for (Comment comment : step.getComments()) {
        if (hasText(comment.getValue())
            && (comment.getValue().contains("{") && comment.getValue().contains("}"))) {
          String line = comment.getValue();
          // do not add new line for listing, complex blocks, callouts
          if (comment.getValue().contains("[source")
              || line.contains("====")
              || line.contains(Constants.Markup.listing())
              || (line.startsWith("<") && line.endsWith(">"))) {
            docBuilder.textLine(
                line.replace("\n", newLine())
                    .replace("#{", "")
                    .replace("# {", "")
                    .replace("}", ""));
          } else {
            docBuilder.textLine(
                line.replace("\n", newLine())
                    .replace("#{", newLine())
                    .replace("# {", newLine())
                    .replace("}", ""));
          }
        }
        // add new line to last comment
        if (step.getComments().indexOf(comment) == numComments - 1) {
          docBuilder.newLine();
        }
      }
    }
  }

  String renderStepTime(Result result) {
    if (result == null || result.getDuration() == null) {
      return "";
    }
    return " [small right]#(" + Formatter.formatTime(result.getDuration()) + ")#";
  }

  String renderStepTable(Step step) {
    // TODO convert to AsciidocBuilder
    CukedoctorDocumentBuilder builder = newInstance();
    builder.newLine();
    if (hasElements(step.getRows())) {
      builder.newLine();
      builder
          .append("[cols=\"" + step.getRows()[0].getCells().length + "*\", options=\"header\"]")
          .newLine();
      builder.textLine(table());
      Row header = step.getRows()[0];
      for (String col : header.getCells()) {
        builder.append(tableCol(), col).newLine();
      }

      for (int i = 1; i < step.getRows().length; i++) {
        for (String cell : step.getRows()[i].getCells()) {
          builder.append(tableCol(), cell).newLine();
        }
      }
      builder.textLine(table());
      builder.newLine();
    }

    return builder.toString();
  }
}
