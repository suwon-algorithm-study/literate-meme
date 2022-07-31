package yeonuk.baekjoon.미로탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Input input = new Input();
            input.init();

            Maze maze = new Maze(input);
            maze.escape(0, 0, input.getN() - 1, input.getM() - 1);

            System.out.println(maze.getCount());

        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }
}

class Maze {

    private final int row;
    private final int col;
    private final int[][] map;
    private final int[][] visitHistories;

    private int count;


    public Maze(Input input) {
        this.row = input.getN();
        this.col = input.getM();
        this.map = new int[this.row][this.col];
        initMap(input.getValues());
        this.visitHistories = new int[this.row][this.col];
        this.count = 0;
    }

    private void initMap(int[][] values) {
        for (int i = 0; i < row; i++) {
            System.arraycopy(values[i], 0, this.map[i], 0, col);
        }
    }

    public void escape(int startX, int startY, int endX, int endY) {
        Location start = new Location(startX, startY);
        Location end = new Location(endX, endY);
        move(start, end);
    }

    private void move(Location start, Location end) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(start);
        visit(start);
        count++;
        
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Location current = queue.poll();

                if (current.equals(end)) {
                    return;
                }

                for (Direction direction : Direction.ofAllDirection()) {
                    int nx = current.nextX(direction);
                    int ny = current.nextY(direction);

                    Location next = new Location(nx, ny);

                    if (validArea(next) && canMove(next)) {
                        queue.add(next);
                        visit(next);
                    }
                }
            }
            count++;
        }
    }

    private void visit(Location next) {
        visitHistories[next.getX()][next.getY()] = 1;
    }

    private boolean isRoad(Location next) {
        return map[next.getX()][next.getY()] == 1;
    }

    private boolean isVisited(Location next) {
        return visitHistories[next.getX()][next.getY()] == 1;
    }

    private boolean validArea(Location next) {
        int nx = next.getX();
        int ny = next.getY();
        return nx >= 0 && ny >= 0 && nx < row && ny < col;
    }

    private boolean canMove(Location next) {
        return isRoad(next) && !isVisited(next);
    }

    public int getCount() {
        return count;
    }
}

class Location {
    
    private final int x;
    private final int y;

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

    public int nextX(Direction direction) {
        return this.x + direction.getDx();
    }

    public int nextY(Direction direction) {
        return this.y + direction.getDy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (x != location.x) return false;
        return y == location.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

class Direction {

    private int dx;
    private int dy;

    public static List<Direction> ofAllDirection() {
        return Arrays.asList(
                Direction.of(0, 1),
                Direction.of(1, 0),
                Direction.of(0, -1),
                Direction.of(-1, 0)
        );
    }

    private static Direction of(int nx, int ny) {
        Direction direction = new Direction();
        direction.dx = nx;
        direction.dy = ny;
        return direction;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}

class Input {

    private int n;
    private int m;

    private int[][] values;

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        values = new int[n][m];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            String token = stk.nextToken();
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(String.valueOf(token.charAt(j)));
                values[i][j] = value;
            }
        }

        br.close();
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int[][] getValues() {
        return values;
    }
}
