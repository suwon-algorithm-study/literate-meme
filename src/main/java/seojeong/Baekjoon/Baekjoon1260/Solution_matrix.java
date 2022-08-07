package seojeong.Baekjoon.Baekjoon1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_matrix {

    static int n,m,v;
    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;

        }
        dfs(v);
        visited = new boolean[n+1];
        System.out.println();
        bfs(v);

    }
    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");

        for(int i=1; i<=n; i++){
            if(!visited[i] && map[v][i] == 1){
                dfs(i);
            }
        }
    }
    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x+" ");
            for(int i=1; i<=n; i++){
                if(!visited[i] && map[x][i] == 1){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
