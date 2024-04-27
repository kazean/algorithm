package baekjoon.basic2.graph;

import java.util.LinkedList;
import java.util.Scanner;

public class BfsDFS_Main_1260 {
    public static boolean[] visited;
    public static boolean[][] point;
    public static int start;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int pointCnt = sc.nextInt();
        int visitedCnt = sc.nextInt();
        start = sc.nextInt();
        sc.nextLine();

        visited = new boolean[pointCnt+1];
        point = new boolean[pointCnt+1][pointCnt+1];

        for(int i = 0; i<visitedCnt; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            sc.nextLine();
            point[s][e] = true;
            point[e][s] = true;
        }
        dfs(start);
        visited = new boolean[pointCnt+1];
        System.out.println();
        bfs(start);

        sc.close();

    }

    public static void bfs(int start){
        LinkedList<Integer> q = new LinkedList<>();
        boolean flag = false;
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int temp = q.pop();
            System.out.print(temp + " ");

            for(int i=1; i<point.length; i++){
                if(point[temp][i] && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");

        for(int i=1; i<point.length; i++){
            if(point[start][i] && !visited[i]){
                dfs(i);
            }
        }
    }
}
