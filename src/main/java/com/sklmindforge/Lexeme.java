package com.sklmindforge;

import ai.djl.huggingface.tokenizers.HuggingFaceTokenizer;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Lexeme {
    private static HuggingFaceTokenizer engine;

    static {
        try (InputStream is = Lexeme.class.getClassLoader().getResourceAsStream("lexeme_v3_100k.json")) {
            if (is == null) throw new RuntimeException("Lexeme JSON not found!");
            
            // Convert InputStream to String because newInstance likes Strings/Paths
            String jsonContent;
            try (Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name())) {
                jsonContent = scanner.useDelimiter("\\A").next();
            }
            
            // Use newInstance with the actual JSON string
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
