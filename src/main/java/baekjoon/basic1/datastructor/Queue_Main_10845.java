package baekjoon.basic1.datastructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Queue_Main_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> q = new LinkedList<>();

        int cmdCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < cmdCount; i++) {
            String[] commands = br.readLine().split(" ");
            if ("push".equals(commands[0])) {
                q.add(Integer.parseInt(commands[1]));
            } else if ("pop".equals(commands[0])) {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println("-1");
                }
            } else if ("size".equals(commands[0])) {
                System.out.println(q.size());
            } else if ("front".equals(commands[0])) {
                if (!q.isEmpty()) {
                    System.out.println(q.peek());
                } else {
                    System.out.println("-1");
                }
            } else if ("back".equals(commands[0])) {
                if (!q.isEmpty()) {
                    System.out.println(q.getLast());
                } else {
                    System.out.println("-1");
                }
            } else if ("empty".equals(commands[0])) {
                if (q.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }
    }
}