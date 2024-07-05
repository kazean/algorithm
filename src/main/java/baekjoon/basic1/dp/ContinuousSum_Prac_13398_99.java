package baekjoon.basic1.dp;
/**
 * 연속합2
 * https://www.acmicpc.net/problem/13398
 *
 * - n개의 정수로 이루어진 임의의 수열이 주어진다.
 * - 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 * - 단, 수는 한 개 이상 선택해야 한다.
 * - 또, 수열에서 수를 하나 제거할 수 있다. (제거하지 않아도 된다)
 *
 * 입/출력
 * - 입력
 * > - 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고
 * > - 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다.
 * > - 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다
 * - 출력
 * > - 첫째 줄에 답을 출력한다.
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

public class ContinuousSum_Prac_13398_99 {
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

        int[] dp1 = new int[N];
        dp1[0] = arr[0];

        int ans = dp1[0];

        // 오른쪽 방향으로 최대 연속 합을 각각 저장함.
        for (int i = 1; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);

            ans = Math.max(ans, dp1[i]);
        }

        int[] dp2 = new int[N];
        dp2[N - 1] = arr[N - 1];

        // 왼쪽 방향으로 최대 연속 합을 각각 저장함.
        for (int i = N - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1] + arr[i], arr[i]);
        }

        // 특정 값을 지웠다고 가정하고, 그 값의 오른쪽 방향과 왼쪽 방향의 최대 연속 합을 더함.
        // 윗줄에서 구한 값과 ans를 비교하여 더 큰 값으로 갱신.
        for (int i = 1; i < N - 1; i++) {
            int temp = dp1[i - 1] + dp2[i + 1];

            ans = Math.max(ans, temp);
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
