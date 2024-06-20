package baekjoon.basic1.dp;
/**
 * https://www.acmicpc.net/problem/9465
 * 2*N개의 스티커, 스티커 기준 위, 아래, 왼쪽, 오른쪽 찢어짐
 * 스티커 점수
 * > 최대 점수
 * N (1 <= N <= 100_000)
 * 점수 (0 <= 점수 <= 100)
 *
 * 입/출력
 * 테스크 케이스 T
 * [N
 * 점수..]
 */
/*
2
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80
>
260
290
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sticker_Prac_Main_9465 {
    static int[][] fieldArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseNum; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n+1];
            fieldArr = new int[2][n+1];

            for (int j = 0; j < 2; j++) {
                int[] numArr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                fieldArr[j] = numArr;
            }

            dp[0][0] = 0;
            dp[1][0] = 0;
            dp[0][1] = fieldArr[0][0];
            dp[1][1] = fieldArr[1][0];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + fieldArr[0][j-1];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + fieldArr[1][j-1];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
