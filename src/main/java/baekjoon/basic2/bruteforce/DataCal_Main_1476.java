package baekjoon.basic2.bruteforce;
/**
 * 날짜게임 - https://www.acmicpc.net/problem/1476
 * (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
 */
/*
1 16 16
> 16
1 1 1
> 1
1 2 3
> 5266
 */
import java.io.*;
import java.util.*;

public class DataCal_Main_1476 {
    static int E, S, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        E = S = M = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int result = 0;
        int tmpE, tmpS, tmpM;
        tmpE = tmpS = tmpM = 0;

        while (!(tmpE == E && tmpS == S && tmpM == M)) {
            tmpE+=1;
            tmpS+=1;
            tmpM+=1;
            if (tmpE == 16) {
                tmpE = 1;
            }
            if (tmpS == 29) {
                tmpS = 1;
            }
            if (tmpM == 20) {
                tmpM = 1;
            }
            result++;
        }

        System.out.println(result);
    }
}
