package baekjoon.basic1.dp;
/**
 * RGB거리2
 * https://www.acmicpc.net/problem/17404
 *
 * RGB 색칠할 수 있는 N개집
 * 1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
 * N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
 * i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.
 *
 * 입/출력
 * - 입력
 * > - 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다.
 * > - 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
 * - 출력
 * > - 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 */
/*
3
26 40 83
49 60 57
13 89 99
6
30 19 5
64 77 64
15 19 97
4 71 57
90 86 84
93 32 91
> 208
[ 반례 ]
6
10 20 30
10 20 30
10 20 30
10 20 30
10 20 30
10 20 30
> 90 (RGRGRG)
5
9 2 8
8 6 5
4 8 5
3 8 2
6 8 8
> 19
 */
import java.io.*;

public class RGB2_Chal_Main_17404_99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];
        int[][] dp = new int[n + 1][3];
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            String[] costs = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(costs[0]);
            arr[i][1] = Integer.parseInt(costs[1]);
            arr[i][2] = Integer.parseInt(costs[2]);
        }

        // R, G, B 반복
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) dp[1][j] = arr[1][i];
                else dp[1][j] = 1_000_001;
            }

            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if(i != j) answer = Math.min(answer, dp[n][j]);
            }
        }

        System.out.println(answer);
    }
}
