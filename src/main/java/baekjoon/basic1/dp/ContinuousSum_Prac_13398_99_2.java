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
import java.util.StringTokenizer;

public class ContinuousSum_Prac_13398_99_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][2]; // j = 0: 수를 제거 하지 않음, j = 1: 특정 수를 제거 함.
        dp[0][0] = dp[0][1] = arr[0];

        int ans = arr[0];
        for (int i = 1; i < N; i++) {
            // 특정 수를 제거하지 않을 경우에는 원래 방식대로 최대 연속 합을 구함.
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);

            // 특정 수를 제거할 경우에는 2가지 케이스를 고려해야 한다.
            // (1) i번째 수가 처음 제거되는 경우
            // -> 단순히 이전 최대 연속 합을 할당하면 됨.
            // (2) i번째 수 전에 지워진 수가 있는 경우
            // -> 현재 수는 지울 수 없으므로 이전 최대 연속 합에다가 arr[i]를 더함.
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);

            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
