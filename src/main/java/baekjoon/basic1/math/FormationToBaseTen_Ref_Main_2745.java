package baekjoon.basic1.math;
/**
 * https://www.acmicpc.net/problem/2745
 * 진법변환
 * In/Out:
 ZZZZZ 36
 > 60466175
 */

import java.io.*;

public class FormationToBaseTen_Ref_Main_2745 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        String formationNum = inputs[0].toLowerCase();
        int radix = Integer.parseInt(inputs[1]);

        System.out.println(Integer.parseInt(formationNum, radix));
    }
}
