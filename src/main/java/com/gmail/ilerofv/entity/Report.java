package com.gmail.ilerofv.entity;

public class Report {
    private int count;
    private double average;

    public Report(int count, double average) {
        this.count = count;
        this.average = average;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Report{" + "count=" + count + ", average=" + average + '}';
    }

}
