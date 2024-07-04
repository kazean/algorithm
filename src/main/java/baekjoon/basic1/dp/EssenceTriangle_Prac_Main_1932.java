package baekjoon.basic1.dp;
/**
 * 정수 삼각형
 * https://www.acmicpc.net/problem/1932
 *
 * 맨 위에서 아래까지 내려올때 최대 수의 합, 현재 값에서 윗 라인에 대각선 좌우 이동가능
 * 삼각형 크기 1 <= N <= 500
 * 0 <= 정수 <= 9999
 *
 * 입/출력
 * - 입력
 * > - 첫째 줄: 삼각형 크기(N)
 * > - 둘째 줄 ~ N+1번째 줄 정수 삼각형
 * - 출력
 * 경로에 있는 수의 합
 */
/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
> 30
 */

import java.io.*;
import java.util.*;

public class EssenceTriangle_Prac_Main_1932 {
    static int N;
    static int[][] fields;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fields = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            fields[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dp[0][0] = fields[0][0];
        for(int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], (dp[i][j] + fields[i + 1][j]));
                if (j + 1 < N) {
                    dp[i + 1][j + 1] = dp[i][j] + fields[i + 1][j + 1];
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if(dp[N-1][i] > result)
                result = dp[N - 1][i];
        }
        System.out.println(result);

    }
}
