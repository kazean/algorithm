package baekjoon.basic1.math;

import java.io.*;

public class GoldbachPartition_Prac_Main_17103 {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        initPrime();

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int j = 2; j <= num / 2; j++) {
                if (!isPrime[j] && !isPrime[num - j]) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }

    public static void initPrime() {
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }
}