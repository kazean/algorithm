package programmers.graphtree;
/*
Floyd Warshall

n	results	return
5	{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}	2
 */
public class Solution49191 {
    static int[][] field;

    public int solution(int n, int[][] results) {
        int answer = 0;
        field = new int[n][n];

        for (int[] result : results) {
            int a = result[0]-1;
            int b = result[1]-1;
            field[a][b] = 1;
            field[b][a] = -1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
//                    field[i][j] = Math.min(field[i][k] + field[k][j], field[i][j]);
                    if (i != j && field[i][k] != 0 && field[k][j] != 0) {
                        if (field[i][j] == 0 && field[i][k] == field[k][j]) {
                            field[i][j] = field[i][k];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < field.length; i++) {
            int count = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (i != j && field[i][j] != 0 ) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }

}
