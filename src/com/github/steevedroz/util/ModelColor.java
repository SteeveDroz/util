package com.github.steevedroz.util;

public class ModelColor {
    private double r;
    private double g;
    private double b;
    private double a;

    public ModelColor(int r, int g, int b, int a) {
	this.r = r / 255.0;
	this.g = g / 255.0;
	this.b = b / 255.0;
	this.a = a / 255.0;
    }

    public ModelColor(int r, int g, int b) {
	this(r, g, b, 255);
    }

    public double getR() {
	return r;
    }

    public double getG() {
	return g;
    }

    public double getB() {
	return b;
    }

    public double getA() {
	return a;
    }

    public void setR(double r) {
	this.r = r;
    }

    public void setG(double g) {
	this.g = g;
    }

    public void setB(double b) {
	this.b = b;
    }

    public void setA(double a) {
	this.a = a;
    }

    public java.awt.Color getAwtColor() {
	return new java.awt.Color((float) r, (float) g, (float) b, (float) a);
    }

    public javafx.scene.paint.Color getJavaFxColor() {
	return new javafx.scene.paint.Color(r, g, b, a);
    }
}
