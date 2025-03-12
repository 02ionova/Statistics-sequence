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
    public int getCount() {  // Добавлен метод getCount()
        return numbers.size();
    }

    @Override
    public double getAverage() {  // Переименован в соответствии с интерфейсом
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

        double mean = getAverage(); // Используем getAverage()
        double sumSquaredDifferences = 0;

        for (double num : numbers) {
            sumSquaredDifferences += Math.pow(num - mean, 2);
        }

        return Math.sqrt(sumSquaredDifferences / (numbers.size() - 1));
    }

    @Override
    public String getFormattedStatistics() {
        return String.format("%d %.3f %.3f", numbers.size(), getAverage(), getStandardDeviation());
    }
}
