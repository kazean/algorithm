package baekjoon.basic1.dp;

/**
 * 이친수 - 2193
 *
 * N = 90자리
 * 1> 1 : 1
 * 2> 10 : 1
 * 3> 100, dp[1] 101 : 2
 * 4> 1000, dp[2] 1010, dp[1] 1001 : 3
 * 5> 10000, dp[3] 10100, 10101, dp[2] 10010, dp[1] 10001 : 5
 * 6> 100000, dp[4] 101000, 101010, 101001, dp[3] 100100, 100101, dp[2] 100010, dp[1] 100001 : 8
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryNumber_Main_2193 {
    static long[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[N]);
        br.close();
    }
}
