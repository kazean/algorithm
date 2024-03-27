package baekjoon.basic1.datastructor;
/**
 * 실패
 *
 * 후위표기식
 * https://www.acmicpc.net/problem/1918
 * <p>
 * # 문제:
 * 입력: 중위표기식
 * 출력: 후위표기식
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_Ref_Main_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if ('+' == tmp || '-' == tmp || '/' == tmp || '*' == tmp) {
                char nextTmp = s.charAt(i + 1);
                i++;
                if ('(' == nextTmp) {
                    stack.push(String.valueOf(tmp));
                    continue;
                } else {
                    queue.add(String.valueOf(nextTmp));
                    queue.add(String.valueOf(tmp));
                }
            } else {
                if(')' == tmp){
                    queue.add(stack.pop());
                    continue;
                }
                queue.add(String.valueOf(tmp));
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        System.out.println(sb.toString());
    }

}
