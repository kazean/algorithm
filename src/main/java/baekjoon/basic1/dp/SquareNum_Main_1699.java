package baekjoon.basic1.dp;
/**
 * 제곱합
 * N 보다 작은 수의 제곱합
 * 1 <= N <= 100_000
 *
 * 입/출력
 * 7 > 4
 * 1 > 1
 * 4 > 1
 * 11 > 3
 * 13 > 2
 *
 * 반례
 * 753
 * # Output
 * 4
 * # Answer
 * 3 (625 + 64 + 64 = 753)
 */


import java.io.*;
import java.util.StringTokenizer;

public class SquareNum_Main_1699 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j] + 1) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
        System.out.println(dp[N]);

    }
}
