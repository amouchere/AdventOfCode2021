package com.amouchere.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SlidingMeasurementTest {

    @Test
    void sum() {

        SlidingMeasurement testMe = new SlidingMeasurement();

        testMe.addMeasure(2);
        testMe.addMeasure(1);
        testMe.addMeasure(3);

        Assertions.assertEquals(6, testMe.sum());
    }
}