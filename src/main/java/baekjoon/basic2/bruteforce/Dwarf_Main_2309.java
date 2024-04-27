package baekjoon.basic2.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dwarf_Main_2309 {
    static int[] field = new int[9];
    static boolean[] visited = new boolean[9];
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < field.length; i++) {
            field[i] = Integer.parseInt(br.readLine());
        }

        dp(0, 0, 0);
    }

    public static void dp(int index, int depth, int sum) {
        if (flag) {
            return;
        }
        if (sum == 100 && depth == 7) {
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) results.add(field[i]);
            }

            results.stream()
                    .sorted()
                    .forEach(System.out::println);
            flag = true;
            return;
        }

        for (int i = index; i < field.length; i++) {
            if (flag) break;
            if (!visited[i]) {
                visited[i] = true;
                dp(index+1, depth+1, sum + field[i]);
                visited[i] = false;
            }
        }
    }
}
