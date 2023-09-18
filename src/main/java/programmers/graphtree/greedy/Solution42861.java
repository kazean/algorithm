package programmers.graphtree.greedy;

import java.util.Arrays;

/*
Kruskal
n	costs	return
4	{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}	4
 */
public class Solution42861 {
    static int[] parent;
    static int finalCost;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        finalCost = 0;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            if (find(a) != find(b)) {
                union(a, b);
                finalCost += cost;
            }
        }

        answer = finalCost;

        return answer;
    }

    static int find(int node) {
        if (parent[node] == node) {
            return node;
        } else {
            return find(parent[node]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}
