package baekjoon.basic1.datastructure;
/**
 * 문자열 분석
 * 문자열 소문자, 대문자, 숫자, 공백 개수 출력
 *
 * In: 문자열 1 <= N <= 100
 * Out: 소문자, 대문자, 숫자, 공백 개수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringNImpl_Ref_Main_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        while (true) {
            String tmp = br.readLine();
            if (tmp == null || "".equals(tmp)) {
                break;
            }
            int smallLetterCount, capitalLatterCount, numberCount, spaceCount;
            smallLetterCount = capitalLatterCount = numberCount = spaceCount = 0;
            for (int i = 0; i < tmp.length(); i++) {
                char c = tmp.charAt(i);
                if ('a' <= c && 'z' >= c) {
                    smallLetterCount++;
                } else if ('A' <= c && 'Z' >= c) {
                    capitalLatterCount++;
                } else if ('0' <= c && '9' >= c) {
                    numberCount++;
                } else {
                    spaceCount++;
                }
            }
            sb.append(smallLetterCount+ " " + capitalLatterCount + " " + numberCount + " " + spaceCount + "\n");
        }
        System.out.print(sb.toString());
    }
}
