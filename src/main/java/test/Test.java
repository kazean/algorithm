package test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int num = 20;
        long[] results = new long[num+1];
        results[0] = 1;

        for (int i = 1; i <= num; i++) {
            results[i] = results[i - 1] * i;
            System.out.println(String.format("%d: %d", i, results[i]));
        }

    }
}
