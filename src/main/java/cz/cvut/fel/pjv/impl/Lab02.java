package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.StatsInterface;
import cz.cvut.fel.pjv.TextIO;

public class Lab02 {
    public static void main(String[] args) {
        StatsInterface stats = new Stats();
        TextIO textIO = new TextIO(); // Создаём объект TextIO

        while (true) {
            String line = textIO.getLine(); // Используем метод getLine()
            if (line == null || line.isEmpty()) {
                System.err.println("End of input detected!");
                break;
            }
            try {
                double number = Double.parseDouble(line.trim());
                stats.addNumber(number);
            } catch (NumberFormatException e) {
                System.err.println("A number has not been parsed from line " + line);
            }
        }
        System.out.println(stats.getFormattedStatistics());
    }
}
