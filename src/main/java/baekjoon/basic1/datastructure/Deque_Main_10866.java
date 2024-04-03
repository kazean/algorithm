package baekjoon.basic1.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Deque_Main_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cmdCount = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < cmdCount; i++) {
            String[] cmds = br.readLine().split(" ");
            if ("push_front".equals(cmds[0])) {
                deque.addFirst(Integer.valueOf(cmds[1]));
            } else if ("push_back".equals(cmds[0])) {
                deque.addLast(Integer.valueOf(cmds[1]));
            } else if ("pop_front".equals(cmds[0])) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pollFirst());
                } else {
                    System.out.println("-1");
                }
            } else if ("pop_back".equals(cmds[0])) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pollLast());
                } else {
                    System.out.println("-1");
                }
            } else if ("size".equals(cmds[0])) {
                System.out.println(deque.size());
            } else if ("empty".equals(cmds[0])) {
                if (deque.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }else if ("front".equals(cmds[0])) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.peekFirst());
                } else {
                    System.out.println("-1");
                }
            }else if ("back".equals(cmds[0])) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.peekLast());
                } else {
                    System.out.println("-1");
                }
            }
        }
    }
}
