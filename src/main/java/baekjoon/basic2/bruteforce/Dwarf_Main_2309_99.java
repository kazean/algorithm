package baekjoon.basic2.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dwarf_Main_2309_99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            arr[i] = n;
            sum += n;
        }

        Arrays.sort(arr);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(sum - (arr[i] + arr[j]) == 100) {
                    for (int z = 0; z < 9; z++) {
                        if(i == z || j == z) continue;
                        System.out.println(arr[z]);
                    }
                    return;
                }
            }
        }
    }
}
