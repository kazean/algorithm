package baekjoon.basic1.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2609_99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");

        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[1]);

        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int gcd, lcm;
        gcd = lcm = 0;
        while (min != 0) {
            int r = max % min;
            max = min;
            min = r;

        }
        gcd = max;
        lcm = a * b / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

}
