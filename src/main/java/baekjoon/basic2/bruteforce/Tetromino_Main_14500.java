package baekjoon.basic2.bruteforce;

import java.io.*;
import java.util.*;

public class Tetromino_Main_14500 {
    static int N, M;
    static int result = 0;
    static int[][] fields;
    static boolean[][][] terominos;

    public static void main(String[] args) throws Exception{
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputNM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = inputNM[0];
        M = inputNM[1];
        fields = new int[N][M];

        for(int i = 0; i < N; i++){
            fields[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        terominoInit();

        // search
        for (int i = 0; i < terominos.length; i++) {
            search(i);
        }

        System.out.println(result);


    }

    public static void search(int index) {
        boolean[][] termino = terominos[index];

        // fields 전체 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(i >= 0 && j >= 0 && i + termino.length <= N && j + termino[0].length <= M) {
                    int tmpCount = 0;
                    // field위 teromino count
                    for (int x = i; x < i + termino.length; x++) {
                        for(int y = j; y < j + termino[0].length; y++) {
                            if (termino[x - i][y - j]) {
                                tmpCount += fields[x][y];
                            }
                        }
                    }
                    result = Math.max(tmpCount, result);
                }
            }
        }
    }


    public static void terominoInit() {
        // 대칭 회전 추가하기2
        terominos = new boolean[5][][];
        // 일자
        terominos[0] = new boolean[][]{{true, true, true, true}};
        // 네모
        terominos[1] = new boolean[][]{{true, true}, {true, true}};
        // ㄴ
        terominos[2] = new boolean[][]{{true, false}, {true, false}, {true, true}};
        // 대각
        terominos[3] = new boolean[][]{{true, false}, {true, true}, {false, true}};
        // ㅜ
        terominos[4] = new boolean[][]{{true, true, true}, {false, true, false}};
    }
}
