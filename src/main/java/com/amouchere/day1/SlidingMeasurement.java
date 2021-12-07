package com.amouchere.day1;

import java.util.ArrayList;
import java.util.List;

public class SlidingMeasurement {
    List<Integer> measurements = new ArrayList<>();

    public void addMeasure(int measurement) {
        measurements.add(measurement);
    }

    public int sum() {
        return measurements.stream().reduce(Integer::sum).get();
    }
}
