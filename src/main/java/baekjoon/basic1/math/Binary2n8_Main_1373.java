package baekjoon.basic1.math;
/*
https://www.acmicpc.net/problem/1373
2진수 > 8진수
11001100 > 314

1000000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary2n8_Main_1373 {
    static StringBuilder answer = new StringBuilder(333339);
    static int[] pow = {1, 2, 4};
    static int startI = 0;
    static String inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine();
        String temp; // 답은 string형으로 처리

        int len = inputs.length(), templen;
        if (len % 3 == 1) {
            cal(0, 1);
            startI += 1;
        } else if (len % 3 == 2) {
            cal(0, 2);
            startI += 2;
        }
        for (int i = startI; i < len - 1; i += 3)
            cal(i, 3);
        System.out.println(answer);
    }

    static void cal(int i, int len) {
        int tempsum = 0;
        for (int j = 0; j < len; j++)
            tempsum += (inputs.charAt(i + j) - '0') * pow[len - j - 1];
        answer.append(tempsum);
    }
}
