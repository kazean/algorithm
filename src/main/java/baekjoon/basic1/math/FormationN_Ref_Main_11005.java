package baekjoon.basic1.math;
/**
 * https://www.acmicpc.net/problem/11005
 * 진법변환2
 *
 * In/Out:
 * 60466175 36 > ZZZZZ
 */

import java.io.*;
import java.util.*;

public class FormationN_Ref_Main_11005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        int num = inputs[0];
        int radix = inputs[1];

        System.out.println(Integer.toString(num, radix).toUpperCase());

    }
}
