package com.github.steevedroz.util;

public abstract class DoubleUtil {
    public static double roundToMultiple(double number, double multiple) {
	return Math.round(number / multiple) * multiple;
    }

    public static double map(double value, double sourceFrom, double sourceTo, double destinationFrom,
	    double destinationTo) {
	double percentage = (value - sourceFrom) / (sourceTo - sourceFrom);
	return percentage * (destinationTo - destinationFrom) + destinationFrom;
    }

    public static double weightedAverage(double start, double goal, double percentage) {
	return start + (goal - start) * percentage;
    }
}
