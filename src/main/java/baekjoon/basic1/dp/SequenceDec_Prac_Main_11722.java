package baekjoon.basic1.dp;
/**
 * 가장 긴 감소하는 부분 수열
 * https://www.acmicpc.net/problem/11722
 *
 * - 가장 긴 감소하는 부분 수열을 구하시오
 *
 * 입/출력
 * 입력
 * - 첫째 줄 수열 A의 크기 N ( 1 <= N <= 1_000)
 * - 둘째 줄 수열 Ai
 * 출력
 * - 수열 A의 가장 긴 감소하는 부분 수열의 길이
 */
/*
6
10 30 10 20 20 10
> 3
 */

import java.io.*;
import java.util.*;

public class SequenceDec_Prac_Main_11722 {
    static int N;
    static int[] fields, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        fields = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = 0;
        for (int i = 0; i < fields.length; i++) {
            int fieldNum = fields[i];
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(fieldNum < fields[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}
