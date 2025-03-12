package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.StatsInterface;
import java.util.ArrayList;
import java.util.List;

public class Stats implements StatsInterface {
    private final List<Double> numbers = new ArrayList<>();

    @Override
    public void addNumber(double number) {
        numbers.add(number);

        if (numbers.size() == 11) { // Очищаем только после 11-го элемента
            numbers.remove(0); // Удаляем самый старый элемент, а не очищаем весь список
        }
    }

    @Override
    public int getCount() {
        return numbers.size();
    }

    @Override
    public double getAverage() {
        if (numbers.isEmpty()) return 0;
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }

    @Override
    public double getStandardDeviation() {
        if (numbers.size() < 2) return 0;

        double mean = getAverage();
        double sumSquaredDifferences = 0;

        for (double num : numbers) {
            sumSquaredDifferences += Math.pow(num - mean, 2);
        }

        return Math.sqrt(sumSquaredDifferences / (numbers.size() - 1)); // Должно быть N-1
    }

    @Override
    public String getFormattedStatistics() {
        return String.format("%2d %.3f %.3f", getCount(), getAverage(), getStandardDeviation());
    }
}
