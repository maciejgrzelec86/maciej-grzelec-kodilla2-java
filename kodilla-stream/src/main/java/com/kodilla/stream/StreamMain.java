package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.MathExpression;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        /*ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("xxxxxxxxxx");
        MathExpression code = (a, b) -> a + b;
        MathExpression code2 = FunctionalCalculator::addAToB;
        //expressionExecutor.executeExpression(3, 4, FunctionalCalculator.addAToB());
        //tutaj podkladam schemat/szkielet kodu bez podawania argumentow
        expressionExecutor.executeExpression(3, 4, code);
        expressionExecutor.executeExpression(3, 4, code2);*/

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Ala ma kota 1", String::toUpperCase);
        poemBeautifier.beautify("Ala ma kota 2", s -> "ABC " + s);
        poemBeautifier.beautify("Ala ma kota 3", s -> s.replaceFirst("3", "#3"));
        poemBeautifier.beautify("Ala ma kota 4t", s -> s.replaceAll("t", "T"));
    }
}
