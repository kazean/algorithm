# Graph & Tree
---
## 다익스트라 vs. 플로이드 와샬
- [참고](https://loosie.tistory.com/146)
### 다익스트라(Dijkstra) Algorithm - algorithm.graphtree.Dijkstra
하나의 정점에서 출발했을 때 다른 모든 정점으로의 최단 경로를 구하는 알고리즘  
매번 가장 적은 비용을 가진 노드를 하나씩 꺼낸 다음 그 다음 노드를 거쳐가는 비용, 즉 가장 적은 비용을 하나씩 선택하는 로직
- 매커니즘
> 단일 시작점 최단 경로 알고리즘, 시작정점 s에서 다른 정점들 까지의 최단 거리를 계산  
DP를 활용한 최단경로 탐색 알고리즘
1) 그래프 1차원 배열 > 컴퓨터 2차원 배열
- 그림
> 1번 노드에서 시작 최단 경로 노드를 구함 > 4번 노드
2) 4번노드의 최소비용 들 갱신
> 2번 노드 & 비용 갱신
3) 반복
- 공간 복잡도
> 인접행렬 O(V^2), 권장> 인접리스트 O(V+E)
- 시간 복잡도
> 인접행렬 O(V^2), 권장> 인접리스트 + 우선순위큐 O((V+E)logV)


#### 우선순위 큐를 사용하는 다익스트라 알고리즘 - algorithm.graphtree.FloydWarshall
다익스트라 알고리즘은 너비 우선 탐색과 유사한 형태를 가진 알고리즘으로, 시작점에서 가까운 순서대로 정점을 방문  
가중치가 있는 그래프에서는 너비 우선 탐색을 그대로 적용할 순 없기 때문에 우선순위 큐를 사용하여 이를 해결
- 우선순위 큐 + BFS
- 각 정점까지의 최단 거리를 저장하는 배열 dp[]를 유지하며, 정점을 방문할때마다 인접한 정점을 모두 검사한다.
- 간선 (u, v)를 검사한다고하면 u까지의 최단 거리에 (u,v)의 가중치를 더해 v까지의 경로의 길이를 찾는다.  
만약 이 길이가 최단거리라면 dp[v]를 갱신하고, (v, dp[v])를 큐에 넣는다
```java
public class Dijkstra {
    static List<Node>[] list;
    static int[] dp;
    static boolean[] check;
    static int[][] costs = {{1,2,2}, {1,4,1}, {1,3,5}, {2,3,3}, {2,4,2},
                {3,4,3}, {3,5,1}, {4,5,1}, {5,6,2}, {3,6,5}};
    static int n = 6;
    
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
```


### 플로이드 와샬(Floyd Warshall)
모든 정점에서 다른 모든 정점으로의 최단 경로를 구하는 알고리즘  
거쳐가는 정점을 하나씩 다 설정을 하여 직접 확인하는 방법, 즉 거쳐가는 정점을 기준으로 최단 거리를 구하도록 구성


- 매커니즘
> 2차원 그래프  
Ck(u, v) = Math.min((Ck-1(u,k) + Ck-1(k, v)), Ck-1(u, v))

- 공간 복잡도
> O(V^2)
- 시간 복잡도
> 3중 포문 O(V^3)

```java
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
		
		// Floyd k : 거쳐가는 노드 (기준) 
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
```

---
## Minimun SanningTree MST(최소신장트리 최소스패닝트리)
### 크루스칼(Kruskal) Algorithm - algorithm.graphtree.greedy.Kruskal
크루스칼 알고리즘은 그래프에서 최소 비용 신장 부분 트리를 찾는 알고리즘이다. (V 정점, E 간선)
- [참고](https://sskl660.tistory.com/72)
- 프로그래머스[https://school.programmers.co.kr/learn/courses/30/lessons/42861]


- 조건
> 음수 가중치가 없는 무방향 그래프  
사이클 발생X
- 매커니즘
> `그리디`, `서로소 집합(DisjoinSet)`
1) 주어진 그래프의 모든 간선에 대해서, 간선의 연결비용을 낮은 순으로 오름 차순 정렬한다.
2) 정렬된 간선 순서대로 선택하면서, 간선의 양 끝 정점을 Union 한다. 단, 이때 선택된 두 정점이 같은 집합속에 속해있다면 사이클이 있다고 판단하고 포함시키지 않는다.
> 서로소 집합(DisjoinSet, Union-Find, Merge-Find Set)만 정확히 알고 있으면 매커니즘은 어렵지 않다.
- 시간 복잡도
> O(ElogV)의 시간복잡도, 모든 가중치를 정렬하는데 걸리는 시간 O(ElogE), 간선의 개수는 최대 V^2개가 될수 있으므로  
O(ElogE) = O(logV^2) = O(2LogV) = O(logV)로 볼 수 있고, 최종적으로 O(ElogV)의 시간 복잡도를 갖는다.
```java
public class Kruskal {
    // 정점, 간선
    static int V, E;
    static int[][] graph;
    // 각 노드의 부모
    static int[] parent;
    // 최종적으로 연결된 최소 신장 트리 연결 비용
    static int final_cost;
    
    public void kruskal() {
        // 간선 비용순으로 오름차순 정렬
        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // makeSet
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        // 낮은 비용부터 크루스칼 알고리즘 진행
        for (int i = 0; i < E; i++) {
            // 사이클이 존재하지 않는 경우에만 간선을 선택한다(여기서는 최종 비용만 고려)
            if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
                System.out.println("<선택된 간선>");
                System.out.println(Arrays.toString(graph[i]));
                union(graph[i][0] - 1, graph[i][1] - 1);
                final_cost += graph[i][2];
                System.out.println("<각 노드가 가르키고 있는 부모>");
                System.out.println(Arrays.toString(parent) + "\n");
            }
        }

        System.out.println("최종 비용:" + final_cost);
        sc.close();
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}
```

### 프림(Prim) Algorithm - algorithm.graphtree.greedy.Prims
최소 신장 트리 (Minimum Spanning Tree) 구현에 상요되는 알고리즘으로 시작 정점에서 정점을 추가해가며 단계적으로 트리를 확장하는 기법이다
- [참고](https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java-%ED%94%84%EB%A6%BCPrim-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)
- 프로그래머스[https://school.programmers.co.kr/learn/courses/30/lessons/42861]


- 매커니즘
> 매 순간 최선의 조건을 선택하는 `그리디` 알고리즘 바탕  
정점기준으로 가중치가 가장 적은 간선 선택 > 반복 [우선 순위 큐]
1) 시작 단계는 시작 노드만이 MST 집합에 속한다.
2) 트리 집합에 속한 정점들 중 가장 낮은 가중치의 간선과 연결된 정ㅈ머에 대해 간선과 정점을 MST 트리 집합에 넣는다. (사이클을 막기 위해 연결된 정점이 이미 트리가 속한다면 다음 순서를 넣는다)
3) 2번 과정을 MST 집합의 원소 개수가 그래프의 정점의 개수가 될 때까지 반복한다.
- 시간 복잡도
> 배열로 구현시 O(n^2), 최소 힙으로 구현할 경우 시간 복잡도 O(ElogN)
```java
public class Prims {
    static List<Edge>[] graph;

    public static void prim(int start, int n) {
        boolean[] visit = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int finalCost = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;

            if(visit[v]) continue;

            visit[v] = true;
            finalCost += cost;
            for (Edge e : graph[v]) {
                if (!visit[e.w]) {
                    pq.add(e);
                }
            }
        }

        System.out.println(finalCost);
    }
    
    static class Edge implements Comparable<Edge> {
        int w;
        int cost;

        public Edge(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
```