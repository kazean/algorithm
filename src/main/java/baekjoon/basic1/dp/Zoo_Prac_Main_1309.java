package baekjoon.basic1.dp;
/**
 * https://www.acmicpc.net/problem/1309
 * 2 * N
 * 사자 가로, 세로 붙게 X
 * 1 <= N <= 100_000
 * 사자를 배치 하는 경우의 수 % 9_901
 *
 * 입/출력
 * 4 > 41
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo_Prac_Main_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9_901;
        }
        System.out.println(dp[N]);
    }
}
