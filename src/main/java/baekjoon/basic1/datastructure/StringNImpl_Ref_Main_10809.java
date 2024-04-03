package baekjoon.basic1.datastructure;
/**
 * 알파벳 찾기
 * 입력: 단어, 소문자, 길이 < 100
 * 출력: 각 단어의 처음 등장 위치 없으면 -1
 *
 * in: baekjoon
 * out: 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringNImpl_Ref_Main_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] result = new int[26];
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            char tmp = (char) (97 + i); // 'a' + i
            if (list.contains(tmp)) {
                sb.append(list.indexOf(tmp));
            } else {
                sb.append("-1");
            }
            if (i != result.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
