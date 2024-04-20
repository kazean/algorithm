package baekjoon.basic1.math;
/**
 * https://www.acmicpc.net/problem/1676
 * 
 * 팩토리얼 0의 개수
 * - 입력/출력
 * > 10/2,  3/0
 * 반례: 50 > 12
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial_Main_1676_99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 50
        int cnt = 0;
        cnt+=N/5; // 10
        cnt+=N/25; // 2
        cnt+=N/125;
        System.out.println(cnt);
    }
}
