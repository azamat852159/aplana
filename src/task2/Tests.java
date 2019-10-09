package task2;

import org.junit.Assert;
import org.junit.Test;

public class Tests {
    calc calc = new calc();

    @Test
    public void test1(){
        Assert.assertEquals(2.0,calc.plus("1+1"),0);
    }
    @Test
    public void test2(){
        Assert.assertEquals(4.1,calc.minus("5.2-1.1"),0);
    }
    @Test
    public void test3(){
        Assert.assertEquals(2.8,calc.multiply("1.4*2"),0);
    }
    @Test
    public void test4(){
        Assert.assertEquals(2.5,calc.divide("5/2"),0);
    }
}
