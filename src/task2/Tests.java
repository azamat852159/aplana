package task2;

import org.junit.Assert;
import org.junit.Test;

public class Tests {
    calc calc = new calc();

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Assert.assertEquals(i + j, calc.plus(Integer.toString(i) + "+" + Integer.toString(j)), 0);
            }
        }
    }

    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Assert.assertEquals(i - j, calc.minus(Integer.toString(i) + "-" + Integer.toString(j)), 0);
            }
        }
    }

    @Test
    public void test3() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Assert.assertEquals(i * j, calc.multiply(Integer.toString(i) + "*" + Integer.toString(j)), 0);
            }
        }
    }

    @Test
    public void test4() {
        for (int i = 0; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                Assert.assertEquals((double) i / j, calc.divide(Integer.toString(i) + "/" + Integer.toString(j)), 0);
            }
        }

    }
}
