package com.sklmindforge;

import java.util.Arrays;

public class TestLexeme {
    public static void main(String[] args) {
        System.out.println("--- Lexeme V3 Java Test ---");

        // Test Static Encode/Decode
        long[] A = Lexeme.encode("Hello.");
        System.out.println("Encoded: " + Arrays.toString(A));
        System.out.println("Decoded: " + Lexeme.decode(A));

        // Test the Tokenizer Class (System.in wrapper)
        // We'll just check if the class exists/loads
        LexemeTokenizer tokenizer = new LexemeTokenizer(System.in);
        System.out.println("LexemeTokenizer initialized successfully.");
    }
}
