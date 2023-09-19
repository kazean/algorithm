package algorithm.graphtree;

public class FloydWarshall {

    public static void main(String[] args) {
        int[][] a = {{1,2,5}, {2,1,7},{3,1,2},{1,4,8},{2,3,9},
                {3,4,3}, {4,3,3}};
        int n =4;
        solution(n,a);
    }

    static void solution(int n, int[][] arr) {
        int[][] floyd = new int[n][n];

        // 결과 그래프 초기화
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(i==j) {
                    floyd[i][j]	 =0;
                }else floyd[i][j] = 1_000_000_000;
            }
        }

        // 결과 그래프 입력
        for(int i=0; i<arr.length; i++) {
            floyd[arr[i][0]-1][arr[i][1]-1] = arr[i][2];
        }

        // k : 거쳐가는 노드 (기준)
        for(int k=0; k<n; k++) {
            // i : 출발 노드
            for(int i=0; i<n; i++) {
                // j : 도착 노드
                for(int j=0; j<n; j++) {
                    // i에서 j로 가는 최소 비용 VS
                    //         i에서 노드 k로 가는 비용 + 노드 k에서 jY로 가는 비용
                    if(floyd[i][k] + floyd[k][j] < floyd[i][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(floyd[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
