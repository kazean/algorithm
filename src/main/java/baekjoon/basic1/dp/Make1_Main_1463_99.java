package baekjoon.basic1.dp;

/*
2 > 1
10 > 3
*/
import java.util.Scanner;

public class Make1_Main_1463_99 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] dp = new int[size+1];
        dp[0] = 1000001;
        dp[1] = 0;
        for(int i=2; i<=size; i++){
            int min = dp[0];
            if(i%3 == 0)
                min = Math.min(dp[i/3], min);
            if(i%2==0)
                min = Math.min(dp[i/2], min);
            if(i-1 !=0)
                min = Math.min(min, dp[i-1]);
            dp[i] = min+1;
        }
        System.out.println(dp[size]);
    }
}
