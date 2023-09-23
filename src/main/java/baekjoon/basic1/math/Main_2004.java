package baekjoon.basic1.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        int power2 = power2(n) - power2(n - m) - power2(m);
        int power5 = power5(n) - power5(n - m) - power5(m);
        System.out.println(Math.min(power2, power5));
        br.close();
    }

    public static int power5(int num) {
        int count = 0;
        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        return count;
    }

    public static int power2(int num) {
        int count = 0;
        while (num >= 2) {
            count += num / 2;
            num /= 2;
        }
        return count;
    }
}
