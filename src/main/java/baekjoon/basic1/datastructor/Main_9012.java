package baekjoon.basic1.datastructor;
/*
6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            char[] parenthesisChars = br.readLine().toCharArray();
            for (int j = 0; j < parenthesisChars.length; j++) {
                char parenthesisChar = parenthesisChars[j];
                if (parenthesisChar == '(') {
                    stack.push('(');
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        flag = false;
                    }
                }
            }

            if (flag && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
