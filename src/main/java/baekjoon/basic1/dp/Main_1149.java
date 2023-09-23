package baekjoon.basic1.dp;
/*
## rgb 거리
https://www.acmicpc.net/problem/1149
1 | 2
i-1 | i | i+1
n-1 | n

>> 시간초과
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1149 {
    static int n;
    static int[][] fields;
    static boolean[][] visited;
    static int dp[];
    static int sum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        fields = new int[n][3];
        visited = new boolean[n][3];

        for (int i = 0; i < n; i++) {
            String[] costs = br.readLine().split(" ");
            fields[i][0] = Integer.parseInt(costs[0]);
            fields[i][1] = Integer.parseInt(costs[1]);
            fields[i][2] = Integer.parseInt(costs[2]);
        }
        dp(0, 0);

        System.out.println(sum);
    }
    // 0:R, 1:G, 2:B
    public static void dp(int count, int tmpSum) {
        if (count == n) {
            sum = Math.min(sum, tmpSum);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (count == 0) {
                visited[count][i] = true;
                dp(count+1, tmpSum+ fields[count][i]);
                visited[count][i] = false;
            } else if (count == n-1) {
                if (visited[count - 1][i]) {
                    continue;
                }
                visited[count][i] = true;
                dp(count+1, tmpSum+ fields[count][i]);
                visited[count][i] = false;
            } else {
                if (visited[count - 1][i]) {
                    continue;
                }
                visited[count][i] = true;
                dp(count+1, tmpSum+ fields[count][i]);
                visited[count][i] = false;
            }
        }
    }
}
