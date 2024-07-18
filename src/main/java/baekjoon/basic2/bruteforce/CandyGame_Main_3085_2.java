package baekjoon.basic2.bruteforce;
/**
 * 사탕게임
 */
/*
3
ZCY
ZCP
PYZ
> 2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CandyGame_Main_3085_2 {
    static int N;
    static char[][] fields;
    static int maxLen = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fields = new char[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "");
            fields[i] = st.nextToken().toCharArray();
        }

        search();
        System.out.println(maxLen);
    }

    public static void search() {
        int[] xMove = new int[]{0, 1, 0};
        int[] yMove = new int[]{0, 0, 1};


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < xMove.length; k++) {
                    int x = i + xMove[k];
                    int y = j + yMove[k];

                    if (x >= 0 && x < N && y >= 0 && y < N) {
                        char tmp = fields[i][j];
                        fields[i][j] = fields[x][y];
                        fields[x][y] = tmp;

                        calRowCol(i, j);
                        calRowCol(x, y);

                        tmp = fields[i][j];
                        fields[i][j] = fields[x][y];
                        fields[x][y] = tmp;
                    }
                }
            }
        }
    }

    public static void calRowCol(int x, int y) {
        char tmp = fields[x][y];
        int tmpMaxLen = 1;
        // 행
        for (int i = x+1; i < N; i++) {
            if (tmp == fields[i][y]) {
                tmpMaxLen++;
            } else {
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (tmp == fields[i][y]) {
                tmpMaxLen++;
            } else {
                break;
            }
        }
        if (tmpMaxLen > maxLen) {
            maxLen = tmpMaxLen;
        }
        // 열
        tmpMaxLen = 1;
        for (int i = y+1; i < N; i++) {
            if (tmp == fields[x][i]) {
                tmpMaxLen++;
            } else {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (tmp == fields[x][i]) {
                tmpMaxLen++;
            } else {
                break;
            }
        }
        if (tmpMaxLen > maxLen) {
            maxLen = tmpMaxLen;
        }

    }
}