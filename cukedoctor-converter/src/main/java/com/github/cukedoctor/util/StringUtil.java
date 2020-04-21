package com.github.cukedoctor.util;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Constants.newLine;

public class StringUtil {

    public static String trimAllLines(String text) {
        if (hasText(text)) {
            StringBuilder trimmedDescription = new StringBuilder();
            String[] lines = text.split(newLine());
            for (int i = 0; i < lines.length; i++) {
                trimmedDescription.append(lines[i].trim());
                if (i < lines.length - 1) {
                    trimmedDescription.append(newLine());
                }
            }
            return trimmedDescription.toString();
        }
        return text;
    }

}
