package baekjoon.basic1.dp;
/**
 * https://www.acmicpc.net/problem/1912
 * 연속합
 * 연속된 배열 중 가장 큰 수
 *
 * 입/출력
 * N, 배열
 */
/*
10
10 -4 3 1 5 6 -35 12 21 -1
> 33 // 12 + 21

10
2 1 -4 3 4 -4 6 5 -5 1
> 14 // 3 4 -4 6 5

5
-1 -2 -3 -4 -5
> -1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum_Main_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int MAX = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(dp[i-1] + nums[i], nums[i]);
            dp[i] = tmp;
            MAX = Math.max(MAX, tmp);
        }
        System.out.println(MAX);
    }
}
