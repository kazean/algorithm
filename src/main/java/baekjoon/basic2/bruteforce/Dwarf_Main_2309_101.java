package baekjoon.basic2.bruteforce;
/**
 * 일곱난쟁이
 * https://www.acmicpc.net/problem/2309
 */
/*
20
7
23
19
10
15
25
8
13
>
7
8
10
13
19
20
23

 */
import java.io.*;
import java.util.Arrays;

public class Dwarf_Main_2309_101 {
    static int[] fields = new int[9];
    static boolean[] visited = new boolean[9];
    static boolean resultFlag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            fields[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0, 0);

    }

    public static void dfs(int index, int depth, int sum) {
        if (resultFlag) {
            return;
        }
        if (depth == 7 && sum == 100) {
            resultFlag = true;
            int[] results = new int[7];
            int resultIndex = 0;
            for (int i = 0; i < 9; i++) {
                if (visited[i]) {
                    results[resultIndex++] = fields[i];
                }
            }
            Arrays.sort(results);
            for (int i = 0; i < 7; i++) {
                System.out.println(results[i]);
            }
            return;
        }

        for (int i = index; i < 9; i++) {
            if (!visited[i] && depth < 7 && sum < 100) {
                visited[i] = true;
                dfs(index + 1, depth + 1, sum + fields[i]);
                visited[i] = false;
            }
        }
    }
}
