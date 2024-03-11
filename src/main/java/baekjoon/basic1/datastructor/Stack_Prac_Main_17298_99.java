package baekjoon.basic1.datastructor;
/**
 * 오큰수
 * Stack copy 시간초과
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Stack_Prac_Main_17298_99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int[] arrs = new int[N];

        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < inputs.length; i++) {
            arrs[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < arrs.length; i++) {
            while (!stack.isEmpty() && arrs[stack.peek()] < arrs[i]) {
                arrs[stack.pop()] = arrs[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arrs[stack.pop()] = -1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrs.length; i++) {
            if (i != arrs.length - 1) {
                sb.append(arrs[i]).append(' ');
            } else {
                sb.append(arrs[i]);
            }
        }
        System.out.println(sb.toString());

    }
}
