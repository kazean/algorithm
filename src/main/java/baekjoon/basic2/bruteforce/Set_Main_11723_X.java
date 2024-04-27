package baekjoon.basic2.bruteforce;

import java.io.*;

public class Set_Main_11723_X {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        boolean[] result = new boolean[20];

        for (int i = 0; i < M; i++) {
            String[] commands = br.readLine().split(" ");
            String com = commands[0];
            int num;

            switch(com){
                case "add": {
                    num = Integer.parseInt(commands[1]);
                    result[num - 1] = true;
                    break;
                }
                case "remove": {
                    num = Integer.parseInt(commands[1]);
                    result[num - 1] = false;
                    break;
                }
                case "check": {
                    num = Integer.parseInt(commands[1]);
                    if (result[num - 1]) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }

                    break;
                }
                case "toggle": {
                    num = Integer.parseInt(commands[1]);
                    if (result[num - 1]) {
                        result[num - 1] = false;
                    } else {
                        result[num - 1] = true;
                    }
                    break;
                }
                case "all": {
                    result = new boolean[]{true, true, true, true, true
                            , true, true, true, true, true
                            , true, true, true, true, true
                            , true, true, true, true, true};
                    break;
                }
                case "empty": {
                    result = new boolean[20];
                    break;
                }
            }
        }
    }
}
