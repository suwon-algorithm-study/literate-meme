package seojeong.programmers.카카오프렌즈컬러링북;

public class Solution {

    static int numberOfArea;
    static int maxSizeOfOneArea;

    static int area = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args) {

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        Solution solution = new Solution();
        solution.solution(6,4,picture);
    }

    public int[] solution(int m, int n, int[][] picture){
        numberOfArea = 0;
        maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    numberOfArea++;
                    dfs(i,j,picture,visited);
                }

                if(area > maxSizeOfOneArea){
                    maxSizeOfOneArea = area;
                }
                area = 0;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void dfs(int x, int y, int[][] picture, boolean[][] visited){
        if(visited[x][y]){
            return ;
        }
        // 방문 처리
        visited[x][y] = true;
        area++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크
            if(nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length){
                continue;
            }
            if(picture[x][y] == picture[nx][ny] && !visited[nx][ny]){
                dfs(nx,ny,picture,visited);
            }
        }
    }
}
