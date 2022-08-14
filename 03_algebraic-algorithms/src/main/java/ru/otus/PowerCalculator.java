package ru.otus;

public class PowerCalculator {

    public double calculatePower(double number, int power) {
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        return result;
    }
}
