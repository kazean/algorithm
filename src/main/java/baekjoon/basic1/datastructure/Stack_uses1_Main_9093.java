package baekjoon.basic1.datastructure;
/*
단어 뒤집기 - 9093

2
I am happy today
We want to win the first prize

I ma yppah yadot
eW tnaw ot niw eht tsrif ezirp

>> 스택 이용해서 풀기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stack_uses1_Main_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");
            List<String> reverseList = Arrays.stream(strArr)
                    .map(it -> {
                        int len = it.length();
                        StringBuffer sb = new StringBuffer();
                        for (int j = len - 1; j >= 0; j--) {
                            sb.append(it.charAt(j));
                        }
                        return sb.toString();
                    })
                    .collect(Collectors.toList());
            for (int j = 0; j < reverseList.size(); j++) {
                if (j == reverseList.size() - 1) {
                    System.out.println(reverseList.get(j));
                } else {
                    System.out.print(reverseList.get(j)+ " ");
                }
            }
        }
        br.close();
    }
}
