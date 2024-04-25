package baekjoon.basic1.math;
/**
 * https://www.acmicpc.net/problem/2089
 * -2 진수
 * -13 > 110111
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinusBinary_Prac_Main_2089 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        if (input == 0) {
            System.out.println("0");
        } else {
            while (input != 1) {
                sb.append(Math.abs(input % 2));
                input = (int) Math.ceil((double) input / -2);
            }
            sb.append(input);
        }

        System.out.println(sb.reverse());
    }

}
