package programmers.graphtree;

import java.util.*;

/*
Dijkstra
 */
public class Solution12978 {

    static List<Node>[] graph;
    static boolean[] visited;
    static int[] dp;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new ArrayList[N + 1];
        dp = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            int n1 = r[0];
            int n2 = r[1];
            int cost = r[2];

            Node n1ToNode = new Node(n2, cost);
            Node n2ToNode = new Node(n1, cost);
            graph[n1].add(n1ToNode);
            graph[n2].add(n2ToNode);
            /*

            if (graph[n1].contains(n1ToNode)) {
                dupRemoveGraph(n1, n2, n1ToNode);
            } else {
                graph[n1].add(n1ToNode);
                graph[n2].add(n2ToNode);
            }
            */
        }
        dijkstra(1);
        for (int i = 1; i < N + 1; i++) {
            if (K >= dp[i]) {
                answer++;
            }
        }
        return answer;
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dp[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int to = node.to;
            int cost = node.cost;

            if(visited[to]) continue;
            visited[to] = true;

            for (Node nxt : graph[to]) {
                if (dp[nxt.to] >= dp[to] + nxt.cost) {
                    dp[nxt.to] = dp[to] + nxt.cost;
                    pq.offer(new Node(nxt.to, dp[nxt.to]));
                }
            }
        }
    }

    static void dupRemoveGraph(int a, int b, Node n1) {
        if (graph[a].contains(n1)) {
            int originIdx = graph[a].indexOf(n1);
            Node n2 = graph[a].get(originIdx);
            if (n2.cost > n1.cost) {
                n2.cost = n1.cost;
            }
            originIdx = graph[b].indexOf(n1);
            n2 = graph[b].get(originIdx);
            n2.cost = n1.cost;
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return to == node.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(to);
        }
    }

}
