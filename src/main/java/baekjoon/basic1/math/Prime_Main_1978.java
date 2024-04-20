package baekjoon.basic1.math;
/**
 * 소수 찾기
 * https://www.acmicpc.net/problem/1978
 */
/*
- 입력:
4
1 3 5 7
- 출력:
3

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime_Main_1978 {

    static boolean[] isPrimes = new boolean[1001];
    public static void main(String[] args) throws IOException {
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        isPrime(1000);
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            if(!isPrimes[num]) result++;
        }

        System.out.println(result);
    }

    public static void isPrime(int num) {
        isPrimes[0] = true;
        isPrimes[1] = true;

        for (int i = 2; i < isPrimes.length; i++) {
            if (!isPrimes[i]) {
                for (int j = i * i; j < isPrimes.length; j+=i) {
                    isPrimes[j] = true;
                }
            }
        }

    }
}
