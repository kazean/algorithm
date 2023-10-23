package baekjoon.basic1.dp;
/*
## 1, 2, 3 더하기 3
3
4
7
10
>
7
44
274
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus123_Main_15988 {

    static long[] dp = new long[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp();

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }

    public static void dp() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i-3] + dp[i-2]+ dp[i-1])  % 1000000009;
        }
    }
}
