package baekjoon.basic2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConnectedNode_Main_11724 {
    static int N, M;
    static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> numSet = new HashSet<>();
        boolean flag = false;
        q.add(s);
        numSet.add(s);

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            List<Integer> nodeList = graph.get(poll);

            for (int i = 0; i < nodeList.size(); i++) {
                Integer node = nodeList.get(i);

                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                    numSet.add(node);
                }
            }
        }
    }
}
