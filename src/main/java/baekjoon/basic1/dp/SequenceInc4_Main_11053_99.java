package baekjoon.basic1.dp;
/**
 * 가장 긴 증가하는 부분 수열
 */
/*
6
10 20 10 30 20 50
>
4
10 20 30 50

[반례]
8
1 8 9 9 9 2 3 4
> 4
> 1 2 3 4
6
1 8 9 9 9 2
> 4
> 1 8 9
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SequenceInc4_Main_11053_99 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[n];
        for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];

        int[] order = new int[n];

        int max = 0;
        for(int i=0; i<n; i++) {
            int next = num[i];
            if(answer[max]<next) {
                answer[++max] = next;
                order[i] = max;
            }
            else if(answer[max]==next) {
                order[i] = max;
                continue;
            }
            else {
                // 다음 값이 현재값이 최대 값보다 작은 경우, 현재 값보다 작은 다음 idx에 저장
                int l = 1;
                int r = max;
                while(l<r) {
                    int mid = (l+r)/2;
                    if(next<=answer[mid]) r=mid;
                    else l=mid+1;
                }
                order[i] = l;
                answer[l] = next;
            }
        }
        Stack<Integer> s = new Stack<Integer>();
        int count = max;

        for(int i=n-1; i>=0; i--)
            if(order[i]==count) {
                s.push(num[i]);
                count--;
            }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append(System.lineSeparator());
        while(!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.print(sb);
    }
}