package com.github.cukedoctor.util;

import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

/**
 * Created by pestano on 07/06/15.
 */
public class Formatter {

	private static final PeriodFormatter TIME_FORMATTER = new PeriodFormatterBuilder()
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

	public static String formatTime(Long time) {
		return TIME_FORMATTER.print(new Period(0, time / 1000000));
	}
}
