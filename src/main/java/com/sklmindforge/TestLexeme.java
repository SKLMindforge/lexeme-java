package com.sklmindforge;

import java.util.Arrays;

public class TestLexeme {
    public static void main(String[] args) {
        System.out.println("--- Lexeme V3 Java Test ---");

        // Test 1: Static Encode
        String text = "Hello.";
        long[] encoded = Lexeme.encode(text);
        System.out.println("Text: " + text);
        System.out.println("Encoded IDs: " + Arrays.toString(encoded));

        // Test 2: Static Decode
        // (Using example IDs from your prompt)
        long[] testIds = {10490, 255, 106, 225, 100316};
        String decoded = Lexeme.decode(testIds);
        System.out.println("Decoded Text: " + decoded);
        
        System.out.println("--- Test Complete ---");
    }
}
