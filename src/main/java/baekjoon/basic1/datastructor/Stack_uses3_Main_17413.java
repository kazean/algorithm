package baekjoon.basic1.datastructor;
/*
단어 뒤집기2 - 17413
baekjoon online judge
 */
import java.io.*;
import java.util.Stack;

public class Stack_uses3_Main_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        char[] chars = str.toCharArray();
        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char tmpChar = chars[i];
            if ('>' == tmpChar) {
                flag = false;
                sb.append(tmpChar);
                bw.write(sb.toString());
                sb = new StringBuffer();
            } else if (flag) {
                sb.append(tmpChar);
            } else if ('<' == tmpChar) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                bw.write(sb.toString());
                sb = new StringBuffer();

                flag = true;
                sb.append(tmpChar);
            } else if (' ' == tmpChar) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
                bw.write(sb.toString());
                sb = new StringBuffer();
            } else {
                stack.push(tmpChar);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.append(' ');
        bw.write(sb.toString());
        sb = new StringBuffer();

        br.close();
        bw.flush();
    }
}
