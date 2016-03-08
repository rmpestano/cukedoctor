package com.github.cukedoctor.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;

import static com.github.cukedoctor.util.Assert.hasElements;

import java.util.List;
import java.util.logging.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {

	private String name;
	private String keyword;
	private String line;
	private Result result;
	private Row[] rows;
	private Match match;
	private List<Comment> comments;
	@JsonProperty("doc_string")
	private DocString docString;
	private List<Output> output;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Row[] getRows() {
		return rows;
	}

	public void setRows(Row[] rows) {
		this.rows = rows;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@JsonRawValue
	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}

	public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

	public DocString getDocString() {
		return docString;
	}

	public void setDocString(DocString docString) {
		this.docString = docString;
	}

	public Long getDuration() {
		if (result == null) {
			return 1L;
		} else {
			return result.getDuration();
		}
	}

	public Status getStatus() {
		if (result == null || result.getStatus() == null) {
			Logger.getLogger(getClass().getName()).warning("Line " + line + " : " + "Step is missing Result: " + keyword + " : " + name);
			return Status.missing;
		} else {
			return result.getStatus();
		}
	}

	public boolean isFailling() {
		return getStatus().equals(Status.failed);
	}

	public boolean isMissing() {
		return getStatus().equals(Status.missing);
	}

	public boolean isPassing() {
		return getStatus().equals(Status.passed);
	}

	public boolean isPendding() {
		return getStatus().equals(Status.pending);
	}

	public boolean isUndefined() {
		return getStatus().equals(Status.undefined);
	}

	public boolean isSkipped() {
		return getStatus().equals(Status.skipped);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Step step = (Step) o;

		if (!name.equals(step.name)) return false;
		return match.equals(step.match);

	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

    public boolean hasComments() {
        return hasElements(comments);
    }

	public boolean hasDiscreteComment() {
		if(hasComments()){
			for (Comment comment : comments) {
				if(comment.getValue().contains("cukedoctor-discrete")){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean hasOutput(){
		 return output != null && !output.isEmpty();
	}
}
