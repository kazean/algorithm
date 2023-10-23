package baekjoon.basic1.dp;
/**
 * 합분해 - 2225
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumUp_Main_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        int[][] dp = new int[N + 1][K + 1];
        int mod = 1000000000;

        for (int i = 1; i < N + 1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i < K + 1; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
            }
        }

        System.out.println(dp[N][K]);
    }
}
