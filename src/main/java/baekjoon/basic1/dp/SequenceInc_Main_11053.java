package baekjoon.basic1.dp;
/**
 * 가장 긴 증가하는 부분 수열
 */
/*
6
10 20 10 30 20 50
> 4

[반례]
8
1 8 9 9 9 2 3 4
> 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SequenceInc_Main_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequences = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] dp = new int[N];
        int MAX = Integer.MIN_VALUE;

        dp[0] = 0;
        for (int i = 0; i < sequences.length; i++) {
            int tmpMax = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (sequences[j] < sequences[i]) {
                    tmpMax = Math.max(tmpMax, dp[j] + 1);
                }
            }
            dp[i] = tmpMax;
            MAX = Math.max(dp[i], MAX);
        }

        System.out.println(MAX);
    }

}