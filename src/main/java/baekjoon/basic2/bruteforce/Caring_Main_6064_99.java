package baekjoon.basic2.bruteforce;
/**
 *
 */
/*
2
10 12 3 3
10 12 3 1
> 3, 13

3
10 12 3 9
10 12 7 2
13 11 5 6
> 33, -1 , 83
1
10 12 7 2
> -1
1
10 12 10 12
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Caring_Main_6064_99 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M, N, x, y;
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int answer = -1;
            int n = 0;
            int lcm = M * N / gcd(M, N);
            while (n * M < lcm) {
                if ((n * M + x - y) % N == 0) {
                    answer = n * M + x;
                    break;
                }
                n++;
            }
            System.out.println(answer);
        }
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
