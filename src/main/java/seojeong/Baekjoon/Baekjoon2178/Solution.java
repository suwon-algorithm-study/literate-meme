package seojeong.Baekjoon.Baekjoon2178;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};

    static int n,m;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];


        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        System.out.println(bfs());

    }
    public static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));

        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            count++;

            for(int t=0; t<size; t++){
                Node now = q.poll();

                for(int i=0; i<4; i++){
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(isValid(nx,ny)){
                        if(n-1 == nx && m-1 == ny){
                            return count;
                        }
                        if(map[nx][ny] == 1 && !visited[nx][ny]){
                            q.add(new Node(nx,ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static boolean isValid(int x, int y){
        if(x >= 0 && x<n && y >= 0 && y <m){
            return true;
        }
        return false;
    }



}
