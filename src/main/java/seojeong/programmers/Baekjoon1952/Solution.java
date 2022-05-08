package seojeong.programmers.Baekjoon1952;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[][] visited = new boolean[m][n];

        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};

        int x = 0;
        int y = 0;

        int dir = 1;
        int answer = 0;

        while(true){
            if(visited[y][x]){
                break;
            }
            visited[y][x] = true;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx >=n || ny <0 || ny >=m || visited[ny][nx]){
                if(dir == 3){
                    dir = 0;
                }
                else{
                    dir++;
                }
                answer++;
            }
            x += dx[dir];
            y += dy[dir];
        }
        // 마지막에 추가되는 1값 뺴기
        System.out.println(answer-1);
    }
}
