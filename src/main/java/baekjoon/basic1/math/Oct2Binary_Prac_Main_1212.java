package baekjoon.basic1.math;
/**
 * https://www.acmicpc.net/problem/1212
 * 8진수 - 2진수
 * 입력:
 * 314 > 11001100
 * 0 > 0
 *
 * > 주의 길이 333,334 (Overflow)
 */

import java.io.*;

public class Oct2Binary_Prac_Main_1212 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();

        for(int i=0; i<length; i++) {
            int num = Integer.parseInt(String.valueOf(input.charAt(i)));
            switch (num) {
                case 7:
                    System.out.print("111");
                    break;
                case 6:
                    System.out.print("110");
                    break;
                case 5:
                    System.out.print("101");
                    break;
                case 4:
                    System.out.print("100");
                    break;
                case 3:
                    if (i != 0) {
                        System.out.print("011");
                    } else {
                        System.out.print("11");
                    }
                    break;
                case 2:
                    if (i != 0) {
                        System.out.print("010");
                    } else {
                        System.out.print("10");
                    }
                    break;
                case 1:
                    if (i != 0) {
                        System.out.print("001");
                    } else {
                        System.out.print("1");
                    }
                    break;
                case 0:
                    if (i != 0) {
                        System.out.print("000");
                    } else {
                        System.out.print("0");
                    }
                    break;
            }
        }
    }
}
