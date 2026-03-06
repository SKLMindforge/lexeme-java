package com.sklmindforge;

import ai.djl.huggingface.tokenizers.HuggingFaceTokenizer;
import java.io.InputStream;
import java.io.IOException;

public class Lexeme {
    private static HuggingFaceTokenizer engine;

    static {
        try (InputStream is = Lexeme.class.getClassLoader().getResourceAsStream("lexeme_v3_100k.json")) {
            if (is == null) throw new RuntimeException("Lexeme V3 JSON not found!");
            engine = HuggingFaceTokenizer.newInstance(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load Lexeme Engine", e);
        }
    }

    // Static encode for your Lexeme.encode() requirement
    public static long[] encode(String text) {
        return engine.encode(text).getIds();
    }

    // Static decode for your Lexeme.decode() requirement
    public static String decode(long[] ids) {
        return engine.decode(ids);
    }
}
