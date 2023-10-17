package baekjoon.basic1.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GcdLcd_Main_2609 {
    static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");

        List<Integer> drainageList = new ArrayList<>();

        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[1]);
        prime();

        int gcd, lcm;
        gcd = lcm = 0;
        boolean flag = true;
        int min = Math.min(a, b);
        while (flag) {

            boolean next = false;
            int i = 2;
            for (i = 2; i <= min; i++) {
                if (!prime[i]) {
                    if (a % i == 0 && b % i == 0) {
                        drainageList.add(i);
                        a = a / i;
                        b = b / i;
                        next = true;
                        break;
                    }
                }
            }
            if (i == min +1) {
                next = false;
            }

            if (!next) {
                flag = false;
                gcd = drainageList.stream()
                        .mapToInt(num -> (int) num)
                        .reduce(1, (num1, num2) -> {
                            return num1 * num2;
                        });
                lcm = gcd * a * b;
            }
            min = Math.min(a, b);
        }
        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static void prime() {
        prime[0] = prime[1] = true;

        for (int i = 0; i <= 10000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}
