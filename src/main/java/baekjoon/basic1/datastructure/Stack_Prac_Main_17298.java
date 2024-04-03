package baekjoon.basic1.datastructure;
/**
 * 오큰수
 * Stack copy 시간초과
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_Prac_Main_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int[] arrs, nge;

        N = Integer.parseInt(br.readLine());
        arrs = new int[N];
        nge = new int[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < inputs.length; i++) {
            arrs[i] = Integer.parseInt(inputs[i]);
        }

        Stack<Integer> s = new Stack<>();
        for (int i = arrs.length - 1; i >= 0; i--) {
            s.push(arrs[i]);
        }

        for (int i = 0; i < arrs.length; i++) {
            int num = s.pop();
            int result = -1;
            Stack<Integer> copyS = (Stack<Integer>) s.clone();

            while (!copyS.isEmpty()) {
                Integer nextNum = copyS.pop();
                if (nextNum > num) {
                    result = nextNum;
                    break;
                }
            }
            nge[i] = result;
        }

        for (int i = 0; i < nge.length; i++) {
            if (i != nge.length - 1) {
                System.out.print(nge[i] + " ");
            } else {
                System.out.println(nge[i]);
            }
        }
    }
}
