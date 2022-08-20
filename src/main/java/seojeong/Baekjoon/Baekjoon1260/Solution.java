package seojeong.Baekjoon.Baekjoon1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int n,m,v;
    static boolean[] visited;
    static List<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            map.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        for(int i=0; i<=n; i++){
            Collections.sort(map.get(i));
        }

        dfs(v);
        visited = new boolean[n+1];
        System.out.println();
        bfs(v);
    }
    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");

        for(int i=0; i<map.get(v).size(); i++){
            int y = map.get(v).get(i);
            if(!visited[y]){
                dfs(y);
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
            for(int i=0; i<map.get(x).size(); i++){
                int y = map.get(x).get(i);
                if(!visited[y]){
                    visited[y] = true;
                    q.offer(y);
                }
            }
        }
    }
}
