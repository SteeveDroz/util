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

    public static double distance(double[] start, double[] end) {
	if (start.length != end.length) {
	    throw new IndexOutOfBoundsException("start and end points must have the same number of coordinates");
	}
	double squaredDistance = 0;
	for (int i = 0; i < start.length; i++) {
	    squaredDistance += (end[i] - start[i]) * (end[i] - start[i]);
	}
	return Math.sqrt(squaredDistance);
    }

    public static double[] getDirectedLength(double[] start, double[] goal, double distance) {
	double totalDistance = distance(start, goal);
	double[] location = new double[start.length];

	for (int i = 0; i < location.length; i++) {
	    double ratio = (totalDistance == 0) ? 0 : distance / totalDistance;
	    location[i] = (goal[i] - start[i]) * ratio;
	}

	return location;
    }
}
