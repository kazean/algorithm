package baekjoon.basic2.bruteforce;
/**
 *  리몬컨
 *  https://www.acmicpc.net/problem/1107
 */
/*
5457
3
6 7 8
> 6
5 4 5 5 + +


// 현재 예외
80000
2
8 9
> 2228
500000
8
0 2 3 4 6 7 8 9
> 11117
 */

import java.io.IOException;
import java.util.Scanner;

public class Remote_Main_1107_99 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int size = sc.nextInt();

        //0-9 까지의 수 중 고장난 채널이 있는지 확인하기 위한 배열
        boolean[] broken = new boolean[10];
        for (int i = 0; i < size; i++) {
            broken[sc.nextInt()] = true;
        }
        //N-100을 RESULT의 초기값으로 주는 이유는 현재 채널이 100부터 시작하기 때문이다.
        int result = Math.abs(N - 100);

        //그냥 0부터 999999까지 전부 확인한다.
        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);

            boolean isBreak = false;
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    //고장난 버튼을 눌러야 하면 멈춘다.1
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                //버튼을 누르는 횟수 중 가장 적은 횟수를 result에 담는다.
                int min = Math.abs(N - i) + num.length();
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }

}