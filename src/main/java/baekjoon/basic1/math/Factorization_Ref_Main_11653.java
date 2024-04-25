package baekjoon.basic1.math;
/**
 * https://www.acmicpc.net/problem/11653
 * 소인수분해
 *
 */
/*
In/Out:
72
>
2
2
2
3
3
 */

import java.io.*;
import java.util.*;

public class Factorization_Ref_Main_11653 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        List<Integer> results = new ArrayList<>();
        while (num != 1) {
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    num /= i;
                    results.add(i);
                    break;
                }
            }
        }

        results.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
