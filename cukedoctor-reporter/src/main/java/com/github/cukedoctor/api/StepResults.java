package com.github.cukedoctor.api;

import com.github.cukedoctor.api.model.Status;
import com.github.cukedoctor.api.model.Step;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pestano on 04/06/15.
 */
public class StepResults {
	private final PeriodFormatter TIME_FORMATTER = new PeriodFormatterBuilder()
			.appendDays()
			.appendSuffix("d")
			.appendSeparator(" ")
			.appendHours()
			.appendSuffix("h")
			.appendSeparator(" ")
			.minimumPrintedDigits(2)
			.appendMinutes()
			.appendSuffix("m")
			.appendSeparator(" ")
			.minimumPrintedDigits(2)
			.appendSeconds()
			.appendSuffix("s")
			.appendSeparator(" ")
			.minimumPrintedDigits(3)
			.appendMillis()
			.appendSuffix("ms")
			.toFormatter();

	private List<Step> allSteps;
	private Map<Status, AtomicInteger> statusCounter;
	private long totalDuration;

	public StepResults(List<Step> allSteps, Map<Status, AtomicInteger> statusCounter, long totalDuration) {
		this.allSteps = allSteps;
		this.statusCounter = statusCounter;
		this.totalDuration = totalDuration;
	}

	public int getNumberOfSteps() {
		return allSteps.size();
	}

	public int getNumberOfPasses() {
		return statusCounter.get(Status.passed).intValue();
	}

	public int getNumberOfFailures() {
		return statusCounter.get(Status.failed).intValue();
	}

	public int getNumberOfUndefined() {
		return statusCounter.get(Status.undefined).intValue();
	}

	public int getNumberOfPending() {
		return statusCounter.get(Status.pending).intValue();
	}

	public int getNumberOfSkipped() {
		return statusCounter.get(Status.skipped).intValue();
	}

	public int getNumberOfMissing() {
		return statusCounter.get(Status.missing).intValue();
	}

	public long getTotalDuration() {
		return totalDuration;
	}

	public String getTotalDurationAsString() {
		return TIME_FORMATTER.print(new Period(0, totalDuration / 1000000));
	}
}
