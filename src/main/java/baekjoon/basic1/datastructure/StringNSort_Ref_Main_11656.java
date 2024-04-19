package baekjoon.basic1.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringNSort_Ref_Main_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            String tmp = input.substring(i, input.length());
            lists.add(tmp);
        }

        lists = lists.stream().sorted().collect(Collectors.toList());

        lists.forEach(System.out::println);
    }
}
