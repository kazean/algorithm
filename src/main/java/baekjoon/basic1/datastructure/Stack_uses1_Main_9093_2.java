package baekjoon.basic1.datastructure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_uses1_Main_9093_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<String> s = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                sb.setLength(0);
                sb.append(word);
                bw.write(sb.reverse().toString()+ " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
