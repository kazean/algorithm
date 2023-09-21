package baekjoon.basic1.datastructor;
/*
10828 스택

push
pop     > 스택 가장 위의 수를 출력, 없으면 -1
size    > 개수 출력
empty   > 비어있으면 1, 있으면 0
top     > 가장 위에 있는 정수, 없으면 0

14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top

2
2
0
2
1
-1
0
1
-1
0
3
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class Main_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String commandStr = br.readLine();
            String[] comArr = commandStr.split(" ");
            String command = comArr[0];

            switch (comArr[0]) {
                case "push":
                    stack.push(Integer.valueOf(comArr[1]));
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
        br.close();
    }
}
