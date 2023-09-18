# Graph & Tree
---
## 다익스트라 vs. 플로이드 와샬
### 다익스트라(Dijkstra)

### 플로이드 와샬(Floyd Warshall)
---
## Minimun SanningTree MST(최소신장트리 최소스패닝트리)
### 크루스칼(Kruskal) Algorithm - algorithm.graphtree.Kruskal
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

### 프림(Prim) Algorithm - algorithm.graphtree.Prims
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