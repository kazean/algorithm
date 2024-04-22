package baekjoon.basic1.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gcd_Prac_Main_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int numCount = inputs[0];
            long result = 0;

            for (int j = 1; j < numCount; j++) {
                int num1 = inputs[j];
                for (int k = j + 1; k <= numCount; k++) {
                    int num2 = inputs[k];
                    result += gcd(num1, num2);
                }
            }
            System.out.println(result);
        }
    }

    public static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
        }
        return num1;
    }
}
