package ru.krista.papers.yargu.industrial.soft.dev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

/**
 * Массовый калькулятор целых чисел.
 * Читает задания из входного файла, пишет решения в выходной файл.
 */
public class MassCalculator {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] argv) throws IOException {
        try (LineNumberReader reader = new LineNumberReader(new FileReader("C:\\Users\\term9\\Documents\\Projects\\debug\\debug\\input.txt"));
             FileWriter fileWriter = new FileWriter("output.txt")) {
            String line;
            while ((line = reader.readLine()) != null) {
                Scanner in = new Scanner(line);
                long aLong = in.nextLong();
                String op = in.next();
                long bLong = in.nextLong();
                int aInt = (int) aLong;
                int bInt = (int) bLong;
                String solution;
                try {
                    String resLong = calculate(aLong, op, bLong);
                    String resInt = calculate(aInt, op, bInt);
                    if (!compare(resLong, resInt)) {
                        throw new NumberFormatException();
                    }
                    solution = aLong + " " + op + " " + bLong + " = " + resLong + "\n";
                    fileWriter.write(solution);
                } catch (ArithmeticException ex) {
                    logger.info("Error is / by zero in line #" + (reader.getLineNumber() - 1) + " " + line);
                } catch (NumberFormatException ex) {
                    logger.info("Overflow in line #" + (reader.getLineNumber() - 1) + " " + line);
                } finally {
                    in.close();
                }
            }
        }
    }

    public static boolean compare(String resLong, String resInt) throws NumberFormatException {
        return (Long.parseLong(resLong) != Integer.parseInt(resInt)) ? false : true;
    }

    public static String calculate(long a, String operation, long b) {
        switch (operation) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                return String.valueOf(a / b);
            default:
                return "Не знаю такую операцию: " + operation;
        }
    }

}
