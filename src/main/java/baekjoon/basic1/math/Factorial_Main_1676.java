package baekjoon.basic1.math;
/**
 * https://www.acmicpc.net/problem/1676
 *
 * 팩토리얼 0의 개수
 * - 입력/출력
 * > 10/2,  3/0
 * 반례: 50 > 12
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial_Main_1676 {
    static int[] zeros = new int[501];
    public static void main(String[] args) throws IOException {
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        initZero();
        System.out.println(zeros[num]);

    }

    public static void initZero() {
        int twoCnt = 0;
        int fiveCnt = 0;

        for (int i = 1; i < zeros.length; i++) {
            int tmp = i;

            while (tmp % 2 == 0) {
                tmp /= 2;
                twoCnt++;
            }

            while (tmp % 5 == 0) {
                tmp /= 5;
                fiveCnt++;
            }
            zeros[i] = Math.min(twoCnt, fiveCnt);
        }
    }
}
