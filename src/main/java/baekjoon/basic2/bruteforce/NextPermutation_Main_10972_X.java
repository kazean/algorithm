package baekjoon.basic2.bruteforce;

/**
 * https://www.acmicpc.net/problem/10972
 * 다음 순열
 *
 */
/*
4
1 2 3 4
> 1 2 4 3
5
5 4 3 2 1
> -1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NextPermutation_Main_10972_X {
    static int N;
    static String inputs;
    static char[] answer;
    static boolean[] visited;
    static boolean flag = false;
    static boolean breakFlag = false;
    static String result = "-1";


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = br.readLine();
        answer = new char[N * 2 - 1];
        visited = new boolean[N+1];

        for (int i = 1; i < N; i++) {
            answer[i * 2 - 1] = ' '; // 1, 3, 5, 7, ...
        }

        permutation(0);

        System.out.println(result);

    }

    public static void permutation(int depth) {
        if (depth == N) {
            String tmpResult = String.valueOf(answer);
            if (flag) {
                result = tmpResult;
                breakFlag = true;
            }
            if (!breakFlag && inputs.equals(tmpResult)) {
                flag = true;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (breakFlag) {
                return;
            }
            if (!visited[i]) {
                visited[i] = true;
                answer[2 * depth] = (char) ('0' + i); //0, 2, 4, ...
                permutation(depth + 1);
                answer[2 * depth] = ' ';
                visited[i] = false;
            }
        }

    }
}
