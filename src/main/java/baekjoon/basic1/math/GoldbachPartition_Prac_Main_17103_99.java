package baekjoon.basic1.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 997
public class GoldbachPartition_Prac_Main_17103_99 {
    static List<Integer> lists = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] sosu = new boolean[1000001];
        sosu[0] = true;
        sosu[1] = true;
        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (sosu[i]) continue;
            lists.add(i);
            for (int j = i*i; j < 1000001; j+=i) {
                sosu[j] = true;
            }
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int tmp = sc.nextInt();
            for (int j = 2; j <= tmp/2; j++) {
                if (!sosu[j] && !sosu[tmp-j])
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}