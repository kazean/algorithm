package baekjoon.basic1.dp;
/*
https://www.acmicpc.net/problem/17404
조건 변경
n은 n-1과 1번째에 색과 달라야한다.

26 40 83
49 60 57
13 89 99

*/
import java.io.*;

public class Main_17404 {
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
