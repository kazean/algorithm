package baekjoon.basic1.datastructure;
/**
 * 알파벳개수
 * https://www.acmicpc.net/problem/10808
 *
 * 입력: 소문자 문자열
 * 출력: a~z 개수 띄어서
 *
 * in: baekjoon
 * out: 1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0
 *
 * >> 입력 문자열을 배열에 채워주기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringNImpl_Ref_Main_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs = br.readLine();
        int[] result = new int[26];
        // a: 97, z: 122

        for (int i = 0; i < inputs.length(); i++) {
            char tmp = inputs.charAt(i);
            int index = tmp - 97;
            result[index] += 1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                sb.append(result[i]);
            } else {
                sb.append(result[i]);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
