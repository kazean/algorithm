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
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SequenceInc4_Main_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums;
        int[] dp = new int[N];
        List[] list = new List[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            int idx = i;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (len < dp[j] + 1) {
                        len = dp[j] + 1;
                        idx = j;
                    }
                }
            }
            dp[i] = len;
            if(idx != i)    list[i].addAll(list[idx]);
            list[i].add(nums[i]);
            if (len > max) {
                max = len;
                result = list[i];
            }
        }
        System.out.println(max);
        result.stream()
                .sorted()
                .forEach(i -> System.out.print(i + " "));
    }
}