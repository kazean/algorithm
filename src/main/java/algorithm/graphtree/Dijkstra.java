package algorithm.graphtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    static List<Node>[] list;
    static int[] dp;
    static boolean[] check;

    public static void main(String[] args) {
        int[][] costs = {{1,2,2}, {1,4,1}, {1,3,5}, {2,3,3}, {2,4,2},
                {3,4,3}, {3,5,1}, {4,5,1}, {5,6,2}, {3,6,5}};
        int n = 6;
        solution(n, costs);
    }

    static void solution(int n, int costs[][]) {
        check = new boolean[n + 1];
        dp = new int[n + 1];

        list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];

            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }

        dijkstra(1);

        for (int num : dp) {
            System.out.print(num + " ");
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dp, Integer.MAX_VALUE);

        pq.offer(new Node(start, 0));
        dp[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int to = node.to;

            if(check[to]) continue;

            check[to] = true;
            for (Node nxt : list[to]) {
                if (dp[nxt.to] >= dp[to] + nxt.weight) {
                    dp[nxt.to] = dp[to] + nxt.weight;
                    pq.offer(new Node(nxt.to, dp[nxt.to]));
                }
            }

        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}

