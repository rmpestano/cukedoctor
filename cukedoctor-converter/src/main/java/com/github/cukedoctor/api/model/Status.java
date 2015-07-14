package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import static com.github.cukedoctor.util.Constants.Markup.*;

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
			default:return "";
		}
	}

	public static String getStatusIcon(Status status){
		switch (status){
			case passed: {
				return "icon:thumbs-up[role=\"green\",title=\"Passed\"]";
			}
			case failed: {
				return "icon:thumbs-down[role=\"red\",title=\"Failed\"]";
			}
			case skipped: {
				return "icon:thumbs-down[role=\"purple\",title=\"Skipped\"]";
			}
			case pending: {
				return "icon:thumbs-down[role=\"maroon\",title=\"Pending\"]";
			}
			case undefined: {
				return "icon:thumbs-down[role=\"yellow\",title=\"Undefined\"]";
			}
			case missing: {
				return "icon:thumbs-down[role=\"blue\",title=\"Missing\"]";
			}
			default:return "";
		}
	}

}