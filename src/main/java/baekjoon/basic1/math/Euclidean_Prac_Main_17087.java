package baekjoon.basic1.math;

/**
 * https://www.acmicpc.net/problem/17087
 * 숨박꼭질 6
 */
/*
In/Out
1 1
1000000000
> 999999999

3 81
33 105 57
> 24
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Euclidean_Prac_Main_17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, s;
        int[] line1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = line1[0];
        s = line1[1];

        int[] childs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 1;

        for (int i = 0; i < n; i++) {
            int abs = Math.abs(s - childs[i]);
            if (i == 0) {
                result = abs;
            } else {
                result = gcd(result, abs);
            }
        }

        System.out.println(result);

    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
