package baekjoon.basic1.math;
/**
 * https://www.acmicpc.net/problem/2004
 * 조합 0의 개수 nCm
 * > n!/(n-m)!* m!
 *
 * in: 25 12
 * out: 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial_Main_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int num1 = Integer.parseInt(inputs[0]);
        int num2 = Integer.parseInt(inputs[1]);
        int twoCount = 0;
        int fiveCount = 0;

        twoCount = count(num1, 2) - count(num1 - num2, 2) - count(num2, 2);
        fiveCount = count(num1, 5) - count(num1 - num2, 5) - count(num2, 5);

        System.out.println(Math.min(twoCount, fiveCount));
    }

    public static int count(int tmp, int modNum) {
        int cnt = 0;
        while (tmp >= modNum) {
            cnt += tmp/modNum;
            tmp /= modNum;
        }
        return cnt;
    }
}
