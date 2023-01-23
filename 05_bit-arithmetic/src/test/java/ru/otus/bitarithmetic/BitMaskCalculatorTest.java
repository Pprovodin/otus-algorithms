package ru.otus.bitarithmetic;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.TestData;
import ru.otus.TestDataSource;

import java.util.stream.Stream;

public class BitMaskCalculatorTest {

    @TestFactory
    @DisplayName("For King")
    Stream<DynamicTest> testKing() {
        return DynamicTest.stream(
                new TestDataSource("king"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> {
                    final String bitMask = KingBitMaskCalculator.calculate(getArgument(testData));
                    Assertions.assertEquals(getExpectedBitmask(testData), bitMask);
                    Assertions.assertEquals(getExpectedMovesCount(testData), PopulationCounter.count(bitMask));
                }
        );
    }

    @TestFactory
    @DisplayName("For Knight")
    Stream<DynamicTest> testKnight() {
        return DynamicTest.stream(
                new TestDataSource("knight"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> {
                    final String bitMask = KnightBitMaskCalculator.calculate(getArgument(testData));
                    Assertions.assertEquals(getExpectedBitmask(testData), bitMask);
                    Assertions.assertEquals(getExpectedMovesCount(testData), PopulationCounter.count(bitMask));
                }
        );
    }

    @TestFactory
    @DisplayName("For Bishop")
    Stream<DynamicTest> testBishop() {
        return DynamicTest.stream(
                new TestDataSource("bishop"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> {
                    final String bitMask = BishopBitMaskCalculator.calculate(getArgument(testData));
                    Assertions.assertEquals(getExpectedBitmask(testData), bitMask);
                    Assertions.assertEquals(getExpectedMovesCount(testData), PopulationCounter.count(bitMask));
                }
        );
    }

    @Ignore
    @TestFactory
    @DisplayName("For Rook")
    Stream<DynamicTest> testRook() {
        return DynamicTest.stream(
                new TestDataSource("rook"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> {
                    final String bitMask = RookBitMaskCalculator.calculate(getArgument(testData));
                    Assertions.assertEquals(getExpectedBitmask(testData), bitMask);
                    Assertions.assertEquals(getExpectedMovesCount(testData), PopulationCounter.count(bitMask));
                }
        );
    }

    @Ignore
    @TestFactory
    @DisplayName("For Queen")
    Stream<DynamicTest> testQueen() {
        return DynamicTest.stream(
                new TestDataSource("queen"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> {
                    final String bitMask = QueenBitMaskCalculator.calculate(getArgument(testData));
                    Assertions.assertEquals(getExpectedBitmask(testData), bitMask);
                    Assertions.assertEquals(getExpectedMovesCount(testData), PopulationCounter.count(bitMask));
                }
        );
    }

    private static int getArgument(TestData testData) {
        return Integer.parseInt(testData.getInput().get(0));
    }

    private static int getExpectedMovesCount(TestData testData) {
        return Integer.parseInt(testData.getOutput().get(0));
    }

    private static String getExpectedBitmask(TestData testData) {
        return testData.getOutput().get(1);
    }
}
