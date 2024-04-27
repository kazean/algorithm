package baekjoon.basic2.bruteforce;

/**
 * https://www.acmicpc.net/problem/10972
 * 다음 순열
 */
/*
4
1 2 3 4
> 1 2 4 3
5
5 4 3 2 1
> -1
7
7 2 3 6 5 4 1
> 7 2 4 1 3 5 6
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NextPermutation_Main_10972_99_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if(next_Permutation(a)) {
            for(int val : a) {
                sb.append(val).append(" ");
            }
        }else {
            sb.append("-1");
        }

        System.out.println(sb);
    }

    public static boolean next_Permutation(int a[]) {
        int i = a.length-1;

        //1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾는다.
        while(i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        //i의 위치가 0이면 내림차순(마지막 순열)
        if(i<=0) return false;

        int j = a.length - 1;

        //2. j >= i 이면서 A[j] > A[i-1] 을 만족하는 가장 큰 j를 찾는다.
        while(a[i-1] >= a[j]) {
            j -= 1;
        }

        //3. A[i-1]과 A[j] 를 swap 한다.
        int temp = a[j];
        a[j] = a[i-1];
        a[i-1] = temp;

        j = a.length-1;


        //4. A[i] 부터 순열을 뒤집는다.
        while(i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }

}
