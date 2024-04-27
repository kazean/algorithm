package baekjoon.basic1.dp;
/**
 * https://www.acmicpc.net/problem/11052
 * 카드구하기
 */
/*
4
1 5 6 7
> 10
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Card_Main_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] packs = br.readLine().split(" ");
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int max = Integer.parseInt(packs[i-1]);
            for (int j = 1; j < i; j++) {
                max = Math.max(max, dp[i - j] + dp[j]);
            }
            dp[i] = max;
        }
        System.out.println(dp[n]);

    }
}
