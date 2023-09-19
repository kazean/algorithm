package programmers.graphtree;

public class Solution49191_99 {

    public static void main(String[] args) {
        Solution49191_99 solution = new Solution49191_99();
        solution.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 10000;
            }
        }

        for (int[] result : results) {
            int x = result[0];
            int y = result[1];
            map[x][y] = 1;
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                for (int k = 1; k < map.length; k++) {
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i < map.length; i++) {
            int cnt = 0;
            for (int j = 1; j < map.length; j++) {
                if (map[i][j] < 10000 || map[j][i] < 10000) {
                    cnt++;
                }
            }
            if(cnt == n-1) answer++;
        }

        return answer;
    }
}
