package ru.krista.papers.yargu.industrial.soft.test;

import org.junit.jupiter.api.Test;
import ru.krista.papers.yargu.industrial.soft.dev.MassCalculator;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тесты калькулятора.
 */
class MassCalculatorTest {

    @Test
    void testAddition() {
        assertEquals("3", MassCalculator.calculate(1, "+", 2));
    }

    @Test
    void testSubtraction() {
        assertEquals("-1", MassCalculator.calculate(1, "-", 2));
    }

}