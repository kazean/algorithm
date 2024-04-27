package baekjoon.basic2.bruteforce;

/**
 * https://www.acmicpc.net/problem/10972
 * 다음 순열
 *
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

import java.io.*;
import java.util.*;

public class NextPermutation_Main_10972_99 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean flag = false;
        for(int i = inputs.length -1; i >= 1; i--) {
            if (inputs[i] > inputs[i - 1]) {
                flag = true;
                int index = i - 1;
                for (int j = inputs.length - 1; j > index; j--) {
                    if (inputs[index] < inputs[j]) {
                        int tmp = inputs[index];
                        inputs[index] = inputs[j];
                        inputs[j] = tmp;

                        j = inputs.length - 1;
                        while(i < j) {
                            tmp = inputs[i];
                            inputs[i] = inputs[j];
                            inputs[j] = tmp;
                            i += 1;
                            j -= 1;
                        }
                        break;
                    }
                }
                break;
            }
        }

        if (flag) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < inputs.length; i++) {
                if (i != inputs.length - 1) {
                    sb.append(inputs[i] + " ");
                } else {
                    sb.append(inputs[i] + "\n");
                }
            }
            System.out.println(sb);
        } else {
            System.out.println("-1");
        }
    }
}
