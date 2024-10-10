package baekjoon.basic2.bruteforce;
/**
 *
 */
/*
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
            System.out.println(solve(M, N, x, y));
        }
    }

    public static int solve(int M, int N, int x, int y) {
        int tmpX, tmpY;
        tmpX = tmpY = 0;
        int result = 0;

        while (!(tmpX == x && tmpY == y) ) {
            tmpX++;
            tmpY++;
            result++;
            if (tmpX > M) {
                tmpX = 1;
            }
            if (tmpY > N) {
                tmpY = 1;
            }
            if ((tmpX == M && tmpY == N) && (M != x && N != y)) {
                result = -1;
                break;
            }
        }
        return result;
    }
}
