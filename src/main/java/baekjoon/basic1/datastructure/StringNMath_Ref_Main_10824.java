package baekjoon.basic1.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringNMath_Ref_Main_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        Long num1 = Long.valueOf(inputs[0] + inputs[1]);
        Long num2 = Long.valueOf(inputs[2] + inputs[3]);
        System.out.println(num1 + num2);
    }
}
