package seojeong.Baekjoon.Baekjoon14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x,y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    //0: 빈칸 1:벽 2:바이러스
    // 벽을 3개 세웠을 때 안전영역의 크기를 구하는 것 -> 최댓값 구하기
    // 바이러스는 상하좌우로 퍼짐

    // 알고리즘: 구현, 그래프, bfs, 완전 탐색

    static int[][] map; //계속 돌거라서 원본 자체는 변하면 안됨
    static int n,m;
    static int[] dr = {-1,1,0,0}; //행 -> 세로
    static int[] dc = {0,0,-1,1}; //열 -> 가로

    static int result = 0;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);
    }
    // 반복문 돌면서 벽을 3개 세우는데, 0(빈칸) 일때만 세울수 있도록
    public static void dfs(int depth){
        if(depth == 3){ //벽을 3개 다세웠을때만, 바이러스가 퍼지도록
            bfs();
            return;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    //bfs 탐색 부분
    public static void bfs(){

        int[][] virus_map = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                virus_map[i][j] = map[i][j];
            }
        }
        //맵 돌면서 바이러스면 큐에 넣음
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(virus_map[i][j] == 2){
                    q.add(new Node(i,j));
                }
            }
        }


        while(!q.isEmpty()){
            Node now = q.poll();

            for(int k=0; k<4; k++){
                int nr = now.x + dr[k];
                int nc = now.y + dc[k];

                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    if(virus_map[nr][nc] == 0){
                        virus_map[nr][nc] = 2;
                        q.add(new Node(nr,nc));
                    }
                }
            }
        }
        safe(virus_map);
    }


    //안전 영역 크기 계산
    public static void safe(int[][] virus_map){
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(virus_map[i][j] == 0){
                    count++;
                }
            }
        }
       result = Math.max(result, count);
    }
}

