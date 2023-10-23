package baekjoon.basic1.dp;
/*
## 1로 만들기
https://www.acmicpc.net/problem/1149
1 | 2
i-1 | i | i+1
n-1 | n

>> 시간초과
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGB_Main_1149_99 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] max = new int[n+1][3];
        max[0][0] = max[0][1] = max[0][2] = 0;
        int r, g, b;

        for(int i=0; i<n; i++){
            String tmpLine = br.readLine();
            String[] tmpArrLine = tmpLine.split(" ");
            r = Integer.parseInt(tmpArrLine[0]);
            g = Integer.parseInt(tmpArrLine[1]);
            b = Integer.parseInt(tmpArrLine[2]);
            max[i+1][0] = Math.min(max[i][1], max[i][2]) + r;
            max[i+1][1] = Math.min(max[i][0], max[i][2]) + g;
            max[i+1][2] = Math.min(max[i][0], max[i][1]) + b;
        }

        System.out.println(Math.min(Math.min(max[n][0], max[n][1]), max[n][2]));
    }
}
