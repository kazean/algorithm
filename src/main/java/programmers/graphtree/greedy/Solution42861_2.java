package programmers.graphtree.greedy;

import java.util.*;

/*
Prims
n	costs	return
4	{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}	4
 */
public class Solution42861_2 {

    static List<Edge>[] graph;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] w : costs) {
            int a = w[0];
            int b = w[1];
            int cost = w[2];
            graph[a].add(new Edge(b, cost));
            graph[b].add(new Edge(a, cost));
        }

        answer = prim(0, n);
        return answer;
    }

    public static int prim(int start, int n) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int finalCost = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.node;
            int cost = edge.cost;

            if (visited[node]) continue;

            visited[node] = true;
            finalCost += cost;
            for (Edge e : graph[node]) {
                if (!visited[e.node]) {
                    pq.add(e);
                }
            }
        }

        return finalCost;
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "node=" + node +
                    ", cost=" + cost +
                    '}';
        }
    }

}
