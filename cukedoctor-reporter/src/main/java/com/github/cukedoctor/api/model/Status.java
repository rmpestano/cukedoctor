package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import static com.github.cukedoctor.util.Constants.*;

/**
 * Created by pestano on 04/06/15.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {
	passed, failed, skipped, pending,
	undefined, missing;

	public static String getStatusColor(Status status){
		switch (status){
			case passed: {
				return style("green",bold(passed.name()));
			}
			case failed: {
				return style("red",bold(failed.name()));
			}
			case skipped: {
				return style("blue",skipped.name());
			}
			case pending: {
				return style("orange",bold(pending.name()));
			}
			case undefined: {
				return style("yellow",bold(undefined.name()));
			}
			case missing: {
				return style("blue",bold(missing.name()));
			}
			default:return "";
		}
	}

}