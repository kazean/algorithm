package baekjoon.basic1.dp;
/**
 * 1,2,3 더하기 5
 * 입력 <= 100,000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTowThreePlusFive_Main_15990 {
    public static void main(String[] args) throws IOException {
        final int MAX = 100_000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        final int T = Integer.parseInt(br.readLine());
        long[][]dp = new long[MAX+1][3];

        dp[1] = new long[]{1, 0, 0};
        dp[2] = new long[]{0, 1, 0};
        dp[3] = new long[]{1, 1, 1};

        // init
        for (int i = 4; i <= MAX; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 1_000_000_009;
            dp[i][1] = (dp[i-2][0] + dp[i-2][2]) % 1_000_000_009;
            dp[i][2] = (dp[i-3][0] + dp[i-3][1]) % 1_000_000_009;
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append((dp[num][0] + dp[num][1] + dp[num][2]) % 1_000_000_009 + "\n");
        }
        System.out.println(sb);

    }
}
