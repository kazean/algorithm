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
import java.util.*;

public class Stack_Ref_Main_1918_2 {
    static Deque<String> expDeque = new ArrayDeque<>();
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        // 곱셈 나누기 먼저
        // > 전, 후위 괄호
        init();
    }

    public static void init() {
        // 괄호치기 곱셈, 나눗셈
        makeBracket(0);

        System.out.println(infixToPostfix());
    }

    public static int makeBracket(int index) {
        for (int i = index; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '*' || tmp == '/') {
                String preNum = expDeque.pollLast();
                char nextTmp = s.charAt(i + 1);
                Stack<String> tmpStack = new Stack<>();
                if (")".equals(preNum)) {
                    boolean flag = true;
                    while (flag) {
                        String tmpPre = expDeque.pollLast();
                        if (tmpPre != null && !"(".equals(tmpPre)) {
                            tmpStack.push(tmpPre);
                        } else {
                            tmpStack.push(tmpPre);
                            flag = false;
                        }
                    }
                }
                expDeque.addLast("(");
                while (!tmpStack.isEmpty()) {
                    expDeque.addLast(tmpStack.pop());
                }
                expDeque.addLast(preNum);
                expDeque.addLast(String.valueOf(tmp));
                if (nextTmp == '(') {
                    i = makeBracket(i + 1);
                } else {
                    expDeque.addLast(String.valueOf(s.charAt(++i)));
                }
                expDeque.addLast(")");
            } else {
                expDeque.addLast(String.valueOf(tmp));
                int bracketCnt = 0;

                if (tmp == '(') {
                    bracketCnt++;
                }
                if (tmp == ')') {
                    bracketCnt--;
                    if (bracketCnt == 0) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static String infixToPostfix() {
        String pre = "";
        Stack<String> tmpStack = new Stack<>();
        while (!expDeque.isEmpty()) {
            if (expDeque.size() == 1 && !")".equals(expDeque.peekFirst())) {
                return expDeque.poll();
            }

            String tmp = expDeque.pollFirst();

            if ("(".equals(tmp)) {
                expDeque.addFirst(infixToPostfix());
            } else if (")".equals(tmp)) {
                return pre;
            } else if ("+".equals(tmp) || "-".equals(tmp) || "*".equals(tmp) || "/".equals(tmp)) {
                String nextExp = expDeque.pollFirst();
                if ("(".equals(nextExp)) {
                    nextExp = infixToPostfix();
                }
                expDeque.addFirst(pre + nextExp + tmp);
            } else {
                pre = tmp;
            }
        }
        return "";
    }
}
