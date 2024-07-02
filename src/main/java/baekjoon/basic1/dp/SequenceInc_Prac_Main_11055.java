package baekjoon.basic1.dp;

/**
 * 가장 큰 증가하는 부분 수열
 * https://www.acmicpc.net/problem/11055
 *
 * 그 수열의 증가하는 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램
 *
 * 입/출력
 * - 입력
 * > - 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
 * > - 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
 * - 출력
 * > 첫째 줄에 수열 A의 합이 가장 큰 증가하는 부분 수열의 합을 출력한다.
 */
/*
10
1 100 2 50 60 3 5 6 7 8
> 113
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SequenceInc_Prac_Main_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] numArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = numArr[i];
            int tmpResult = 0;
            boolean flag = false;
            for (int j = i-1; j >= 0; j--) {
                if (numArr[i] > numArr[j]) {
//                    dp[i] += dp[j];
                    tmpResult = Math.max(tmpResult, dp[i] + dp[j]);
                    flag = true;
                }
            }
            if (flag) {
                dp[i] = tmpResult;
            }
        }

        int maxResult = 0;
        for (int i = 0; i < n; i++) {
            maxResult = Math.max(maxResult, dp[i]);
        }
        System.out.println(maxResult);

    }
}
