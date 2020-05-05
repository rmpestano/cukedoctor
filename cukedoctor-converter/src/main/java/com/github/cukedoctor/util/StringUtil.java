package com.github.cukedoctor.util;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Constants.newLine;

public class StringUtil {

    public static String trimAllLines(String text) {
        if (hasText(text)) {
            StringBuilder trimmedDescription = new StringBuilder();
            String[] lines = text.split(newLine());
            boolean shouldTrim = true;
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].trim().startsWith(Constants.Markup.listing())) {
                    if (shouldTrim) {
                        shouldTrim = false;//remove trimming on start listing
                    } else {
                        shouldTrim = true; //enable trimming on end listing
                    }
                }
                if (shouldTrim) {
                    trimmedDescription.append(lines[i].trim());
                } else {
                    trimmedDescription.append(lines[i]);
                }
                if (i < lines.length - 1) {
                    trimmedDescription.append(newLine());
                }
            }
            return trimmedDescription.toString();
        }
        return text;
    }

}
