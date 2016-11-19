package com.github.steevedroz.util;

import java.util.Iterator;

import javafx.geometry.Point2D;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Line;

public class ProgressiveLine {
    private Point2D start;
    private Point2D end;
    private LinearGradient gradient;
    private double dX;
    private double dY;
    private Point2D current;

    public ProgressiveLine(Point2D start, Point2D end, LinearGradient gradient, double step) {
	this.start = start;
	this.end = end;
	this.gradient = gradient;
	this.current = start;

	double x = end.getX() - start.getX();
	double y = end.getY() - start.getY();
	double angle = Math.atan(y / x) + (Math.signum(x) < 0 ? Math.PI : 0);
	this.dX = step * Math.cos(angle);
	this.dY = step * Math.sin(angle);
    }

    public ProgressiveLine(Point2D start, Point2D end, LinearGradient gradient) {
	this(start, end, gradient, 1.0);
    }

    public ProgressiveLine(double startX, double startY, double endX, double endY, LinearGradient gradient,
	    double stop) {
	this(new Point2D(startX, startY), new Point2D(endX, endY), gradient, stop);
    }

    public ProgressiveLine(double startX, double startY, double endX, double endY, LinearGradient gradient) {
	this(new Point2D(startX, startY), new Point2D(endX, endY), gradient);
    }

    public Iterator<Line> getIterator() {
	return new Iterator<Line>() {

	    @Override
	    public Line next() {
		Point2D next = current.add(dX, dY);
		Line line = null;
		try {
		    if (start.getX() != end.getX()) {
			if (Math.abs(next.getX() - start.getX()) >= Math.abs(end.getX() - start.getX())) {
			    throw new Exception();
			}
		    } else if (start.getY() != end.getY()) {
			if (Math.abs(next.getY() - start.getY()) >= Math.abs(end.getY() - start.getY())) {
			    throw new Exception();
			}
		    }
		    line = new Line(current.getX(), current.getY(), next.getX(), next.getY());
		} catch (Exception exception) {
		    line = new Line(current.getX(), current.getY(), end.getX(), end.getY());
		}

		current = next;
		return line;
	    }

	    @Override
	    public boolean hasNext() {
		if (start.getX() != end.getX()) {
		    return Math.abs(current.getX() - start.getX()) < Math.abs(end.getX() - start.getX());
		} else if (start.getY() != end.getY()) {
		    return Math.abs(current.getY() - start.getY()) < Math.abs(end.getY() - start.getY());
		}
		return false;
	    }
	};
    }
}
