package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        double a = 10;
        double b = 2;
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double addResult =calculator.add(a, b);
        double subResult =calculator.sub(a, b);
        double mulResult =calculator.mul(a, b);
        double divResult =calculator.div(a, b);
        //Then
        Assert.assertEquals(12,addResult,0.1);
        Assert.assertEquals(8,subResult, 0.1);
        Assert.assertEquals(20,mulResult,0.1);
        Assert.assertEquals(5,divResult, 0.1);
    }
}
