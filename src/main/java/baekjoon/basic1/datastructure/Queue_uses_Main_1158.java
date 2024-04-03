package baekjoon.basic1.datastructure;

/*
요세ㅐ푸스 문제
7 3
> <3, 6, 2, 7, 5, 1, 4>
 */
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_uses_Main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, k;

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        k = Integer.parseInt(inputs[1]);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        bw.write("<");
        while (!q.isEmpty()) {
            if (q.size() == 1) {
                bw.write(String.valueOf(q.poll()));
                break;
            }
            for (int i = 0; i < k; i++) {
                if (i == (k - 1)) {
                    bw.write(q.poll()+", ");
                } else {
                    q.add(q.poll());
                }
            }
        }
        bw.write(">");
        bw.flush();
        br.close();
    }
}
