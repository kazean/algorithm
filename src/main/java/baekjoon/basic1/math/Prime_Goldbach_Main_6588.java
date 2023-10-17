package baekjoon.basic1.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime_Goldbach_Main_6588 {

    static boolean[] prime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            StringBuffer sb = new StringBuffer();
            sb.append(num + " = ");
            for (int i = 2; i < prime.length; i++) {
                if (!prime[i] && !prime[num-i]) {
                    sb.append(i + " + " + (num - i));
                    break;
                }
            }
            System.out.println(sb.toString());
        }

    }

    public static void isPrime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length + 1); i++) {
            for (int j = i * i; j < prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
}
