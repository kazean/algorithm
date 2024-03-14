package baekjoon.basic1.datastructor;

/**
 * 오등큰수
 * 수열 A1 ~ Ai
 * 등장횟수 F(Ai) Ai의 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수중에서 가장 왼쪽에 있는수
 * 없는 경우 -1
 */

import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.IOException;

public class Stack_Prac_Main_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] arrs = new int[N];
        int[] result = new int[N];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < inputs.length; i++) {
            int key = Integer.parseInt(inputs[i]);
            Integer val = treeMap.getOrDefault(key, Integer.valueOf(0));
            treeMap.put(key, ++val);
            arrs[i] = key;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arrs.length; i++) {
            while (!stack.isEmpty() && treeMap.get(arrs[stack.peek()]) < treeMap.get(arrs[i])) {
                arrs[stack.pop()] = arrs[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arrs[stack.pop()] = -1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrs.length; i++) {
            if (i == arrs.length - 1) {
                sb.append(arrs[i]);
                break;
            }
            sb.append(arrs[i]+ " ");
        }
        System.out.println(sb.toString());

    }
}
