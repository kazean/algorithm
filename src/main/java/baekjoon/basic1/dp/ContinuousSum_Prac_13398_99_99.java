package baekjoon.basic1.dp;
/**
 *
 */
/*
10
10 -4 3 1 5 6 -35 12 21 -1
> 54

// 반례
6
1 2 -4 2 -5 6
> 8 // -5 제거
3
99 -100 -100
> 99
3
-100 -100 99
> 99
 */

import java.io.*;
import java.util.*;

public class ContinuousSum_Prac_13398_99_99 {
    static int N;
    static int[] fields;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fields = new int[N];
        dp = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fields[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i][0] = fields[i];
            dp[i][1] = fields[i];
            if(i > 0){
                // 현재 dp의 MAX: 이전값 연속 or 자기자신
                dp[i][0] = Math.max(dp[i][0], dp[i-1][0] + fields[i]);
                // 현재값 제외 or 제거할 수 없는 경우
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + fields[i]);

            }
            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(result);

    }
}
