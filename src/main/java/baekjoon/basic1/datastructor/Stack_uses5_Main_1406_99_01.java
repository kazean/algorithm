package baekjoon.basic1.datastructor;
/*
스택 - 에디터
 */

import java.io.*;
import java.util.Stack;

public class Stack_uses5_Main_1406_99_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String initStr = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Stack<Character> leftS = new Stack<>();
        Stack<Character> rightS = new Stack<>();

        for (int i = 0; i < initStr.length(); i++) {
            leftS.push(initStr.charAt(i));
        }

        for (int i = 0; i < m; i++) {
            String[] cmdArr = br.readLine().split(" ");
            char cmd = cmdArr[0].charAt(0);
            switch (cmd) {
                case 'L':
                    if (leftS.size() != 0) {
                        rightS.push(leftS.pop());
                    }
                    break;
                case 'D':
                    if (rightS.size() != 0) {
                        leftS.push(rightS.pop());
                    }
                    break;
                case 'B':
                    if (leftS.size() != 0) {
                        leftS.pop();
                    }
                    break;
                case 'P':
                    char add = cmdArr[1].charAt(0);
                    leftS.push(add);
                    break;
            }
        }

        while (!leftS.isEmpty()) {
            rightS.push(leftS.pop());
        }
        while (!rightS.isEmpty()) {
            bw.write(rightS.pop());
        }

        bw.flush();
        bw.close();
    }
}
