package baekjoon.basic1.dp;
/**
 * 가장 긴 바이토닉 부분 수열
 * https://www.acmicpc.net/problem/11054
 * - 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열
 * - 수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성
 *
 * 입/출력
 * 입력
 * - 첫째 줄 수열 A의 크기 N (1 <= N <= 1_000)
 * - 둘째 줄 수열 Ai
 * 출력
 * - 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이
 */
/*
10
1 5 2 1 4 3 4 5 2 1
> 7
 */

import java.io.*;
import java.util.*;

public class BitonicInc_Prac_Main_11054 {
    static int N;
    static int[] fields, dpInc, dpDec;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dpInc = new int[N];
        dpDec = new int[N];
        fields = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i = 0; i < fields.length; i++) {
            dpInc[i] = 1;
            int field = fields[i];
            for(int j = i - 1; j >= 0; j--) {
                if(field > fields[j] && dpInc[i] < dpInc[j] + 1){
                    dpInc[i] = dpInc[j] + 1;
                }
            }
        }

        for(int i = fields.length -1; i >= 0; i--) {
            dpDec[i] = 1;
            int field = fields[i];
            for (int j = i + 1; j < fields.length; j++) {
                if (field > fields[j] && dpDec[i] < dpDec[j] + 1) {
                    dpDec[i] = dpDec[j] + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dpInc[i] + dpDec[i] -1);
        }
        System.out.println(result);
    }
}