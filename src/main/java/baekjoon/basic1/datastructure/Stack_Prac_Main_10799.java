package baekjoon.basic1.datastructure;
/*
쇠막대기 - 10799

()(((()())(())()))(())
> 17


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_Prac_Main_10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < chars.length; i++) {
            char tmpChar = chars[i];
            if ('(' == chars[i] && i + 1 < chars.length && ')' == chars[i + 1]) {
                cnt += stack.size();
                i++;
            } else if ('(' == chars[i]) {
                stack.push('(');
            } else if (')' == chars[i]) {
                stack.pop();
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
