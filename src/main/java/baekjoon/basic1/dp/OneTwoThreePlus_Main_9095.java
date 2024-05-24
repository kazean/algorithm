package baekjoon.basic1.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThreePlus_Main_9095 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] allCnt = new int[11];
        int testCase = Integer.parseInt(br.readLine());
        allCnt[0]=0;
        allCnt[1]=1;
        allCnt[2]=2;
        allCnt[3]=4;

        for(int i=4; i<11; i++){
            allCnt[i] = allCnt[i-1] + allCnt[i-2] + allCnt[i-3];
        }


        for(int i=0; i<testCase; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(allCnt[num]);
        }

    }
}
