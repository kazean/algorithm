package baekjoon.basic1.datastructor;
/**
 * 후위표기식
 * https://www.acmicpc.net/problem/1918
 * <p>
 * # 문제:
 * 입력: 중위표기식
 * 출력: 후위표기식
 * <p>
 * input:
 * A+B*C > ABC*+
 * A+B*C-D/E > ABC*+DE/-
 * A*B*C > AB*C*
 * (((A-B)+C)+D) > AB-C+D+
 * (((A*B)+C)+D) > AB*C+D+
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_Ref_Main_1918_99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < exp.length(); i++) {
            char tmp = exp.charAt(i);

            switch (tmp) {
                case '+':
                case '-':
                case '*':
                case '/':
                    // 이전 연산자가 우선인 경우, 먼저 stack 에 있는 경우를 먼저 append 후 새로운 연산자를 push
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(tmp)) {
                        sb.append(stack.pop());
                    }
                    stack.push(tmp);
                    break;
                case '(':
                    // 괄호의 경우 stack 에 push
                    stack.push(tmp);
                    break;
                case ')':
                    // 괄호가 끝나는 경우 stack 에 있는 경우를 append
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(tmp);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

    }

    public static int priority(char op) {
        if ('(' == op || ')' == op) {
            return 1;
        } else if ('+' == op || '-' == op) {
            return 2;
        } else if ('*' == op || '/' == op){
            return 3;
        }
        return 0;
    }
}
