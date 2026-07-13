package com.cognizant.testing;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorFixtureTest {
    private Calculator calculator;
    @Before public void setUp() { calculator = new Calculator(); }
    @After public void tearDown() { calculator = null; }
    @Test public void addUsesArrangeActAssert() {
        int result = calculator.add(10, 5);
        assertEquals(15, result);
    }
}
