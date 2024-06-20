package baekjoon.basic1.dp;
/**
 * https://www.acmicpc.net/problem/2156
 * 될 수 있는 대로 많은 양의 포도주
 * 첫째 줄에 포도주 잔의 개수 n이 주어진다. (1 ≤ n ≤ 10,000)
 * 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다.
 * - (1 ≤ n ≤ 10,000)
 * - 포도주의 양은 1,000 이하의 음이 아닌 정수이다.
 * - 연속으로 놓여있는 세잔을 마실 수 없다
 *
 * 입/출력
 */
/*
6
6
10
13
9
8
1
> 33

반례
6
100
100
0
0
100
100
> 400
 */

import java.io.*;

public class Wine_Prac_Main_2156_99 {
    static int N;
    static int[] field;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            field[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = field[1];

        if(N > 1) dp[2] = field[1] + field[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-1], Math.max((dp[i-2] + field[i]), (dp[i-3] + field[i-1] + field[i])));
        }
        System.out.println(dp[N]);
    }
}
