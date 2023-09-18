package programmers.graphtree.greedy;

import java.util.Arrays;

class Solution42861_99 {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        Arrays.sort(costs,(int[]c1, int[]c2)-> c1[2]-c2[2]);
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] point : costs) {
            int from = point[0];
            int to = point[1];
            int cost = point[2];

            int fromToParent = findParent(from);
            int toToParent = findParent(to);

            if (fromToParent == toToParent) {
                continue;
            }
            answer += cost;
            parent[toToParent] = fromToParent;
        }
        return answer;
    }

    private int findParent(int node) {
        if(parent[node] == node) return node;

        return findParent(parent[node]);
    }
}