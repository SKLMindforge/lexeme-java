package com.sklmindforge;

import java.io.InputStream;
import java.util.Scanner;

public class LexemeTokenizer {
    private String data;

    public LexemeTokenizer(InputStream source) {
        Scanner sc = new Scanner(source);
        if (sc.hasNextLine()) {
            this.data = sc.nextLine();
        }
    }

    public long[] encode() {
        return Lexeme.encode(this.data);
    }
}
