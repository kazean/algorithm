package baekjoon.basic1.datastructor;

/**
 * 후위 표기식 2
 * https://www.acmicpc.net/problem/1935
 * # 문제 :
 * 피연산자 개수: N
 * 후위표기식: ABC*-DE/- (A~Z 길이 100미만)
 * N: A~Z 대응값
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Stack_Ref_Main_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Double> stack = new Stack<>();
        List<Double> list = new LinkedList<>();
        String[] expression = br.readLine().split("");

        for (int i = 0; i < N; i++) {
            list.add(Double.parseDouble(br.readLine()));
        }

        char start = 'A';
        char end = 'Z';

        for (String e : expression) {
            char tmp = e.charAt(0);
            if (start <= tmp && end >= tmp) {
                int index = tmp - start;
                stack.push(list.get(index));
            } else {
                Double b = stack.pop();
                Double a = stack.pop();
                Double tmpResult = null;
                if ('+' == tmp) {
                    tmpResult = a + b;
                } else if ('-' == tmp) {
                    tmpResult =  a - b;
                } else if ('*' == tmp) {
                    tmpResult = a * b;
                } else if ('/' == tmp) {
                    tmpResult = a / b;
                }
                stack.push(tmpResult);
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));

    }
}
