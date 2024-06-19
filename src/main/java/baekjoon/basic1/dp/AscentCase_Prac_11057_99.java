package baekjoon.basic1.dp;
/**
 * https://www.acmicpc.net/problem/11057
 * 수의 자리가 오름차순, 인접한 수가 같아도 오름차순
 * 수의 길이 N (1 <= N <= 1_000), 오르막 수의 개수, 0으로 시작가능
 *
 * 입/출력
 * N > 결과 % 10_007
 * 1 > 10
 * 2 > 55
 * 3 > 220
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AscentCase_Prac_11057_99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10_007;
                }
            }
        }
        System.out.println(dp[n][0] % 10_007);
    }
}
