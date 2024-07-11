package baekjoon.basic1.dp;

/**
 * 타일 채우기
 * https://www.acmicpc.net/problem/2133
 *
 * 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
 * 입/출력
 * - 입력
 * > - 첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.
 * - 출력
 * > - 첫째 줄에 경우의 수를 출력한다.
 */
/*
2
> 3
3
> 0
4
> 11
5
> 0
6
> 41
 */
import java.io.*;

public class ThreeNTile_Prac_Main_2133_99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[32];
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }

        System.out.println(dp[N]);

    }
}
