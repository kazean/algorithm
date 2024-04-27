package baekjoon.basic2.bruteforce;
/**
 * https://www.acmicpc.net/problem/15649
 * N과 M
 * 입력: N,M / 길이 M 인 수열 / 자연수 1 ~ N / 1 <= M <= N <= 8
 * 출력: 중복 없이 사전순 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NM_Main_15649_99 {
    static char[] answer;
    static boolean[] c;
    static List<char[]> per = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n=Integer.parseInt(st[0]), m=Integer.parseInt(st[1]);

        answer = new char[2 * m];
        for (int i=1;i<m;i++) answer[2*i-1] = ' ';
        answer[2*m -1] = '\n';
        c = new boolean[n+1];

        permutations(n,m,0);
        System.out.println(sb);
    }

    public static void permutations(int n, int m, int depth) {
        if (m==depth) {sb.append(answer); return;}

        for (int i=1; i<=n; i++) {
            if (!c[i]) {
                c[i] = true;
                answer[2*depth] = (char) (i+'0');
                permutations(n,m,depth+1);
                c[i] = false;
            }
        }
    }
}
