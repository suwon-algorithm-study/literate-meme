package yeonuk.programmers.카카오프렌즈_컬러링북;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 0 0 1 1 3 3
 * 1 2 0 0 0 0
 * 1 2 0 0 0 0
 * 1 1 1 0 0 0
 **/
public class Solution {

    private int numberOfArea = 0;

    private int maxSizeOfOneArea = 0;


    public int[] solution(int m, int n, int[][] picture) {
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && visited[i][j] == 0) {
                    bfs(i, j, picture, visited);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void bfs(int i, int j, int[][] picture, int[][] visited) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(i, j));
        visited[i][j] = 1;

        int area = 0;
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            area++;

            for (Direction direction : Direction.ofAll()) {
                int x = location.getX();
                int y = location.getY();

                int dx = direction.getDx();
                int dy = direction.getDy();

                int nx = x + dx;
                int ny = y + dy;

                int value = picture[x][y];

                if (validArea(nx, ny, picture) && canMove(nx, ny, value, picture, visited)) {
                    queue.add(new Location(nx, ny));
                    visited[nx][ny] = 1;
                }
            }
        }

        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
    }

    private boolean validArea(int nx, int ny, int[][] picture) {
        return nx >= 0 && ny >= 0 && nx < picture.length && ny < picture[nx].length;
    }

    private boolean canMove(int nx, int ny, int value, int[][] picture, int[][] visited) {
        return picture[nx][ny] == value && visited[nx][ny] == 0;
    }
}

class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Direction {

    private int dx;
    private int dy;

    public static List<Direction> ofAll() {
        return Arrays.asList(
                Direction.ofUp(),
                Direction.ofDown(),
                Direction.ofLeft(),
                Direction.ofRight()
        );
    }

    private static Direction ofUp() {
        Direction direction = new Direction();
        direction.dx = 0;
        direction.dy = 1;
        return direction;
    }

    private static Direction ofDown() {
        Direction direction = new Direction();
        direction.dx = 0;
        direction.dy = -1;
        return direction;
    }

    private static Direction ofLeft() {
        Direction direction = new Direction();
        direction.dx = -1;
        direction.dy = 0;
        return direction;
    }

    private static Direction ofRight() {
        Direction direction = new Direction();
        direction.dx = 1;
        direction.dy = 0;
        return direction;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
