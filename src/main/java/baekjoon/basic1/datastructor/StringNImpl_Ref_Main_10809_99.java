package baekjoon.basic1.datastructor;
/**
 * 알파벳 찾기
 * 입력: 단어, 소문자, 길이 < 100
 * 출력: 각 단어의 처음 등장 위치 없으면 -1
 *
 * in: baekjoon
 * out: 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class StringNImpl_Ref_Main_10809_99 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[] = br.readLine().toCharArray();
        int num[] = new int[26];
        for (int i = 0; i < 26; i++) {
            num[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            int loc = arr[i] - 97;


            if (num[loc] == -1) {
                num[loc] = i;
                //System.out.println(arr[i] + " = "+loc);

            }
        }
        for (int i = 0; i <  26; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
