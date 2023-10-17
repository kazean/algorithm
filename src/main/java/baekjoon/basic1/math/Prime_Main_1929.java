package baekjoon.basic1.math;
/*
3 16

>
3
5
7
11
13
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime_Main_1929 {

    static boolean[] prime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);

        isPrime();

        for (int i = a; i <= b; i++) {
            if (!prime[i]) {
                System.out.println(i);
            }
        }
    }

    public static void isPrime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (!prime[i]) {
                if (i >= 1001) {
                    continue;
                }
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}
