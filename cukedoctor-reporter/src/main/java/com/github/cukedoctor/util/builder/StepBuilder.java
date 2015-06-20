package com.github.cukedoctor.util.builder;

import com.github.cukedoctor.api.model.Match;
import com.github.cukedoctor.api.model.Result;
import com.github.cukedoctor.api.model.Status;
import com.github.cukedoctor.api.model.Step;

/**
 * Created by pestano on 04/06/15.
 */
public class StepBuilder {

	private Step step;
	private static StepBuilder instance;


	private StepBuilder(Step step) {
		this.step = step;
	}

	private Step getStep() {
		return step;
	}

	public static synchronized StepBuilder instance() {
		instance = new StepBuilder(new Step());
		return instance;
	}

	public StepBuilder keyword(String keyword) {
		step.setKeyword(keyword);
		return instance;
	}


	public StepBuilder name(String name) {
		step.setName(name);
		return instance;
	}


	public StepBuilder match(Match match) {
		step.setMatch(match);
		return instance;
	}

	public StepBuilder result(Result result) {
		step.setResult(result);
		return instance;
	}

	public StepBuilder status(Status status) {
		if (step.getResult() == null) {
			step.setResult(new Result());
		}
		step.getResult().setStatus(status);
		return instance;
	}

	public StepBuilder durations(long duration) {
		if (step.getResult() == null) {
			step.setResult(new Result());
		}
		step.getResult().setDuration(duration);
		return instance;
	}


	public Step build() {
		return this.getStep();
	}
}
