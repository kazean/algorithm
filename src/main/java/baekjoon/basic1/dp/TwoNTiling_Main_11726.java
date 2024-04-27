package baekjoon.basic1.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoNTiling_Main_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] results = new int[size+1];
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        for (int i = 3; i <= size; i++) {
            results[i] = results[i-1]%10007 + results[i-2]%10007;
        }

        System.out.println(results[size]%10007);
    }
}
