package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("DEFG", poem -> "ABC" + poem);
        poemBeautifier.beautify("decorate", poem -> poem.toUpperCase());
        poemBeautifier.beautify("   Lambda Expression   ", poem -> poem.trim());
        poemBeautifier.beautify("Obama", poem -> poem.replace('b', 's'));
    }
}
