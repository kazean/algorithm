package baekjoon.basic2.bruteforce;
/**
 * https://www.acmicpc.net/problem/15649
 * N과 M
 * 입력: N,M / 길이 M 인 수열 / 자연수 1 ~ N / 1 <= M <= N <= 8
 * 출력: 중복 없이 사전순 출력
 */

import java.io.*;
import java.util.*;

public class NM_Main_15649 {
    static int N;
    static int M;
    static boolean[] visited;
    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        visited = new boolean[N + 1];

        dp(new int[M], 0);
        result.stream()
                /*.sorted((o1, o2) -> {
                    int[] a = o1;
                    int[] b = o2;
                    for (int i = 0; i < a.length; i++) {
                        if (a[i] != b[i]) {
                            return a[i] - b[i];
                        }
                    }
                    return 0;
                })*/
                .forEach(it -> {
                    int[] result = it;
                    for (int i = 0; i < result.length; i++) {
                        if (i == result.length - 1) {
                            System.out.println(result[i]);
                        } else {
                            System.out.print(result[i]+" ");
                        }
                    }
                });

    }
    public static void dp(int[] tmpResult, int depth) {
        if (depth == M) {
            result.add(Arrays.copyOf(tmpResult, depth));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmpResult[depth] = i;
                depth++;
                dp(tmpResult, depth);
                visited[i] = false;
                depth--;
                tmpResult[depth] = 0;
            }
        }
    }
}
