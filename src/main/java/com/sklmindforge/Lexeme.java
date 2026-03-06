package com.sklmindforge;

import ai.djl.huggingface.tokenizers.HuggingFaceTokenizer;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Lexeme {
    private static HuggingFaceTokenizer engine;

    static {
        // Updated to match your EXACT filename
        String filename = "Lexeme_V3_Final_Watermarked.json";
        
        InputStream is = Lexeme.class.getResourceAsStream("/" + filename);
        if (is == null) {
            is = Lexeme.class.getClassLoader().getResourceAsStream(filename);
        }

        try {
            if (is == null) {
                throw new RuntimeException("CRITICAL: File " + filename + " not found in src/main/resources/");
            }
            
            String jsonContent;
            try (Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name())) {
                jsonContent = scanner.useDelimiter("\\A").next();
            }
            engine = HuggingFaceTokenizer.newInstance(jsonContent);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Lexeme Engine: " + e.getMessage());
        }
    }

    public static long[] encode(String text) {
        return engine.encode(text).getIds();
    }

    public static String decode(long[] ids) {
        return engine.decode(ids);
    }
}
