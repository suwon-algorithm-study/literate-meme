package dain.연구소;

import java.util.*;

public class Solution {
    static class virus {
        int x,y;

        virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;

    static int[][] map;
    static int[][] copy_map;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        copy_map = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j ++) {
                map[i][j] = sc.nextInt();
            }
        }

        copy_map = map;
        DFS(0);
        System.out.println(result);
    }

    public static void DFS(int depth) {
        if (depth == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    DFS(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void BFS() {
        int [][] virus_map = new int[N][M];
        Queue<virus> que = new LinkedList<virus>();

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                virus_map[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (virus_map[i][j] == 2){
                    que.add(new virus(i,j));
                }
            }
        }

        while (!que.isEmpty()) {
            virus v = que.remove();

            for (int d = 0; d < 4; d++){
                int nx = v.x + dx[d];
                int ny = v.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (virus_map[nx][ny] == 0) {
                        virus_map[nx][ny] = 2;
                        que.add(new virus(nx,ny));
                    }
                }
            }
        }
        safe(virus_map);
    }

    public static void safe(int[][] virus_map) {
        int count = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (virus_map[i][j] == 0) count++;
            }
        }
        result = Math.max(count, result);
    }
}
