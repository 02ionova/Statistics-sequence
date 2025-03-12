package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.StatsInterface;
import java.util.ArrayList;
import java.util.List;

public class Stats implements StatsInterface {
    private final List<Double> numbers = new ArrayList<>();

    @Override
    public void addNumber(double number) {
        if (numbers.size() >= 10) {  // Сбрасываем статистику после 10-го элемента
            numbers.clear();
        }
        numbers.add(number);
    }

    @Override
    public double getAverage() {
        if (numbers.isEmpty()) return 0.0;
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }

    @Override
    public double getStandardDeviation() {
        int n = numbers.size();
        if (n < 2) return 0.0;

        double mean = getAverage();
        double sumSquaredDiffs = 0;
        for (double num : numbers) {
            sumSquaredDiffs += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sumSquaredDiffs / n);
    }

    @Override
    public int getCount() {
        return numbers.size();
    }

    @Override
    public String getFormattedStatistics() {
        int count = getCount();
        double mean = getAverage();
        double stddev = getStandardDeviation();
        return String.format(" %d %.3f %.3f", count, mean, stddev);
    }
}