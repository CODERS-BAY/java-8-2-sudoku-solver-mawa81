package com.codersbay;

import java.util.Arrays;

public class Pattern {
    private final int[][] pattern;
    public int length;

    public Pattern(int[][] pattern) {
        this.pattern = pattern;
    }

    public Pattern() {
        this.pattern = null;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "pattern=" + Arrays.toString(pattern) +
                '}';
    }
}
