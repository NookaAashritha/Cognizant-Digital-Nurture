package com.cognizant.engineering.algorithms;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecastingDemo {
    public static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return futureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static double futureValueMemo(double presentValue, double growthRate, int years, Map<Integer, Double> memo) {
        if (years == 0) return presentValue;
        if (!memo.containsKey(years)) {
            memo.put(years, futureValueMemo(presentValue, growthRate, years - 1, memo) * (1 + growthRate));
        }
        return memo.get(years);
    }

    public static void main(String[] args) {
        double projected = futureValueMemo(10000, 0.08, 5, new HashMap<>());
        System.out.printf("Projected value after 5 years: %.2f%n", projected);
        System.out.println("The direct recursion is O(n) here; memoization helps when repeated overlapping year calculations are requested.");
    }
}
