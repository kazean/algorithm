package baekjoon.basic2.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Count{
    int p;
    int cnt;
    public Count(int p, int cnt) {
        super();
        this.p = p;
        this.cnt = cnt;
    }
}

public class HideNSeek_Main_1697 {
    static int n, k;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        bfs(k, new Count(n, 0));
    }

    public static void bfs(int k, Count c){
        Queue<Count> q = new LinkedList<Count>();
        q.add(c);
        visited[c.p] = true;

        while(!q.isEmpty()){
            Count tmp = q.poll();
            if(tmp.p == k){
                System.out.println(tmp.cnt);
                break;
            }

            if(tmp.p*2 < visited.length && !visited[tmp.p*2]){
                q.add(new Count(tmp.p*2, tmp.cnt+1));
                visited[tmp.p*2]=true;
            }
            if(tmp.p+1 < visited.length &&!visited[tmp.p+1]){
                q.add(new Count(tmp.p+1, tmp.cnt+1));
                visited[tmp.p+1] = true;
            }
            if(tmp.p-1 >=0 &&!visited[tmp.p-1]){
                q.add(new Count(tmp.p-1, tmp.cnt+1));
                visited[tmp.p-1] = true;
            }
        }
    }

}

