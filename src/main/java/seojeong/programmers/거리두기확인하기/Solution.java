package seojeong.programmers.거리두기확인하기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};


        Solution solution = new Solution();
        solution.Solution(places);
    }

    public int[] Solution(String[][] places){
        int[] answer = new int[places.length];

        for(int i=0; i<places.length; i++){
            String[] temp = places[i];

            boolean isCheck = true;

            for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    if(temp[r].charAt(c) == 'P'){
                        if(!bfs(r,c,temp)){
                            isCheck = false;
                        }
                    }
                }
            }
            answer[i] = isCheck? 1:0;
        }
        return answer;
    }
    public static boolean bfs(int r, int c, String[] places){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nr = now.x + dx[i];
                int nc = now.y + dy[i];

                // 범위 체크
                if(nr < 0 || nr >= 5 || nc <0 || nc >= 5 || (nr == r && nc == c)){
                    continue;
                }

                int dist = Math.abs(nr - r) + Math.abs(nc - c);

                // 상하좌우 탐색하면서 응시자간의 거리가 2 이하인 경우
                if(places[nr].charAt(nc) == 'P' && dist <= 2){
                    return false;

                }else if(places[nr].charAt(nc) == 'O' && dist < 2){ // 빈테이블인데 거리 2미만인 경우
                    q.offer(new Point(nr,nc));
                }
            }
        }
        return true;
    }
}
