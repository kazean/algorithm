package baekjoon.basic1.dp;
/**
 * https://www.acmicpc.net/problem/10844
 * 쉬운 계단 수
 * - In/Out
 * 1 > 19
 * 2 > 17
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stairs_Main_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int MAX = 100;
        //                 2_147_483_647
        final int DIVIDE = 1_000_000_000;
        long[][] dp = new long[MAX + 1][10];
        dp[1] = new long[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 2; i <= MAX; i++) {
            for (int j = 0; j <= 9; j++) {
                long preNum = 0;
                long nextNum = 0;
                if(j - 1 >= 0) preNum = dp[i - 1][j - 1];
                if(j + 1 <= 9) nextNum = dp[i -1][j + 1];
                dp[i][j] = (preNum + nextNum) % DIVIDE;
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % DIVIDE;
        }
        System.out.println(result);

    }
}
