package baekjoon.basic1.math;
/**
 * https://www.acmicpc.net/problem/11576
 * Base Conversion
 * - In/Out
 */

/*
17 8
2
2 16
> 6 2
 */
import java.io.*;
import java.util.*;
public class BaseConversion_Ref_Main_11576 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int ARadix = Integer.parseInt(inputs[0]);
        int BRadix = Integer.parseInt(inputs[1]);

        int m = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int radixPos = 1;
        int tenResult = 0;
        for(int i = nums.length-1; i>=0; i--) {
            tenResult += nums[i] * radixPos;
            radixPos *= ARadix;
        }

        List<Integer> results = new ArrayList<>();

        while (tenResult != 0) {
            results.add(tenResult % BRadix);
            tenResult /= BRadix;
        }

        for(int i = results.size()-1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(results.get(i) + " ");
            } else {
                System.out.println(results.get(i));
            }
        }
    }
}
