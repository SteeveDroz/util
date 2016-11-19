package com.github.steevedroz.util;

public abstract class StringUtils {
    public static String join(Object[][] data, char lineSeparator, char elementSeparator) {
	StringBuilder str = new StringBuilder();
	for (int i = 0; i < data.length; i++) {
	    if (i > 0) {
		str.append(lineSeparator);
	    }
	    for (int j = 0; j < data[i].length; j++) {
		if (j > 0) {
		    str.append(elementSeparator);
		}
		str.append(data[i][j].toString());
	    }
	}
	return str.toString();
    }
}
