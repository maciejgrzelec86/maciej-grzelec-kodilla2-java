package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String text,PoemDecorator poemDecorator) {
        text = poemDecorator.decorate(text);
        System.out.println(text);
        return text;
    }
}
