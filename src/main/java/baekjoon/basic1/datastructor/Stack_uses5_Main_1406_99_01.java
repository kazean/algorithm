package baekjoon.basic1.datastructor;
/*
스택 - 에디터
 */
import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Stack_uses5_Main_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String initStr = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < initStr.length(); i++) {
            list.add(initStr.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }

        int idx = list.size();

        int cmdCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cmdCnt; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            if ('P' == c) {
                char t = s.charAt(2);
                iter.add(t);
            } else if ('L' == c) {
                if(iter.hasPrevious()) iter.previous();
            } else if ('D' == c) {
                if(iter.hasNext()) iter.next();
            } else if ('B' == c) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
        }

        for (Character chr : list) {
            bw.write(chr);
        }
        bw.flush();
        bw.close();
    }
}
