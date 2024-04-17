package baekjoon.basic1.datastructure;
/**
 * ROT13
 * 암호화 문자열 + 13
 *
 * 입력: Baekjoon Online Judge
 * 출력: Onrxwbba Bayvar Whqtr
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringNImpl_Ref_Main_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) (c + 13);
                if (c > 'z') {
                    c = (char)(c - 26);
                }
            } else if (c >= 'A' && c <= 'z') {
                c = (char) (c + 13);
                if (c > 'Z') {
                    c = (char)(c - 26);
                }
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
