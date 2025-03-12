package cz.cvut.fel.pjv;

import cz.cvut.fel.pjv.impl.Stats;

public class Main {
    public static void main(String[] args) {
        TextIO textIO = new TextIO();
        Stats stats = new Stats();
        int lineNumber = 1;

        while (true) {
            String line = textIO.getLine().trim();
            if (line.isEmpty()) break;

            if (TextIO.isDouble(line)) {
                stats.addNumber(Double.parseDouble(line));
            } else {
                System.err.printf("A number has not been parsed from line %d%n", lineNumber);
            }
            lineNumber++;
        }

        System.err.println("End of input detected!");
        System.out.println(stats.getFormattedStatistics());
    }
}
