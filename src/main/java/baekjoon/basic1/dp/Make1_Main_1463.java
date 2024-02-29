package baekjoon.basic1.dp;

/*
## 1로 만들기
1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다
> 최소의 경우의수
2 > 1
10 > 3
98 > 7

단순 구현하였을때는 dp[i-1] 과 dp[i/2] dp[i/3] 비교가 없다!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Make1_Main_1463 {
    static int[] dp = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp(n);
        System.out.println(dp[n]);
    }

    public static void dp(int n) {
        dp[0] = 1000001;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int min = dp[0];
            if (i % 2 == 0) {
                min = Math.min(min, dp[i / 2]);
            }
            if (i % 3 == 0) {
                min = Math.min(min, dp[i / 3]);
            }
            if (n - 1 != 0) {
                min = Math.min(min, dp[i - 1]);
            }
            dp[i] = min + 1;
        }
    }
}
