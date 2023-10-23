package baekjoon.basic2.bruteforce;

/**
 * 일곱난쟁이 - 2309
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfs = new int[9];

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dwarfs);

        boolean flag = false;
        int[] answer = new int[7];
        for (int i = 0; i < 8; i++) {
            if(flag) break;
            for (int j = i + 1; j < 9; j++) {
                if(flag) break;
                int[] tmpAnswer = new int[9];
                System.arraycopy(dwarfs, 0,tmpAnswer, 0, 9);
                tmpAnswer[i] = 0;
                tmpAnswer[j] = 0;
                int sum = Arrays.stream(tmpAnswer)
                        .sum();
                if (sum == 100) {
                    flag = true;
                    answer = Arrays.stream(tmpAnswer)
                            .filter(num -> (num != 0))
                            .toArray();
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}