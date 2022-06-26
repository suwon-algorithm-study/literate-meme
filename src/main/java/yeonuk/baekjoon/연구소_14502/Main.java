package yeonuk.baekjoon.연구소_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Input input = new Input();

            Main main = new Main();
            main.solve(input);
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }

    public void solve(Input input) {
        Laboratory laboratory = new Laboratory(input.getValue());
        laboratory.spread();

        System.out.println(laboratory.getMaxSafeZone());
    }

}

class Laboratory {

    private final int[][] map;

    private final LaboratoryService service;

    public Laboratory(int[][] map) {
        this.map = map;
        this.service = new LaboratoryService();
    }

    public void spread() {
        service.move(map, 0);
    }

    public int getMaxSafeZone() {
        return service.getMaxSafeZone();
    }
}

class LaboratoryService {

    private final List<Direction> directions;

    private int maxSafeZone;

    public LaboratoryService() {
        this.directions = Direction.ofDirectionList();
        this.maxSafeZone = 0;
    }

    public void move(int[][] map, int wallCount) {
        if (wallCount == 3) {
            int[][] virusMap = map;

            spread(virusMap);
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (isSafeZone(map, i, j)) {
                    map[i][j] = 1;
                    move(map, wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public void spread(int[][] virusMap) {
        Queue<Location> virusQueue = new LinkedList<>();

        for (int i = 0; i < virusMap.length; i++) {
            for (int j = 0; j < virusMap[i].length; j++) {
                if (virusMap[i][j] == 2) {
                    virusQueue.add(new Location(i, j));
                }
            }
        }

        while (!virusQueue.isEmpty()) {
            Location location = virusQueue.remove();

            for (Direction direction : directions) {
                int nx = location.getX() + direction.getNx();
                int ny = location.getY() + direction.getNy();

                if (immovable(virusMap, nx, ny)) {
                    continue;
                } else if (isSafeZone(virusMap, nx, ny)) {
                    infect(virusMap, nx, ny);
                    virusQueue.add(new Location(nx, ny));
                }
            }
        }

        // 안전지대 최대값
        int count = 0;
        for (int i = 0; i < virusMap.length; i++) {
            for (int j = 0; j < virusMap[i].length; j++) {
                if (virusMap[i][j] == 0) {
                    count++;
                }
            }
        }
        maxSafeZone = Math.max(maxSafeZone, count);
    }

    private boolean immovable(int[][] map, int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length;
    }

    private boolean isSafeZone(int[][] map, int x, int y) {
        return map[x][y] == 0;
    }

    private void infect(int[][] map, int x, int y) {
        map[x][y] = 2;
    }

    public int getMaxSafeZone() {
        return maxSafeZone;
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

    private int nx;

    private int ny;

    public int getNx() {
        return nx;
    }

    public int getNy() {
        return ny;
    }

    public static List<Direction> ofDirectionList() {
        Direction up = Direction.ofUp();
        Direction down = Direction.ofDown();
        Direction left = Direction.ofLeft();
        Direction right = Direction.ofRight();

        return Arrays.asList(up, down, left, right);
    }

    private static Direction ofUp() {
        Direction direction = new Direction();
        direction.nx = 0;
        direction.ny = 1;
        return direction;
    }

    private static Direction ofDown() {
        Direction direction = new Direction();
        direction.nx = 0;
        direction.ny = -1;
        return direction;
    }

    private static Direction ofLeft() {
        Direction direction = new Direction();
        direction.nx = -1;
        direction.ny = 0;
        return direction;
    }

    private static Direction ofRight() {
        Direction direction = new Direction();
        direction.nx = 1;
        direction.ny = 0;
        return direction;
    }
}

class Input {

    private final int n;
    private final int m;

    private final int[][] value;

    public Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());


        value = new int[n][m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                value[i][j] = Integer.parseInt(stk.nextToken());
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

    public int[][] getValue() {
        return value;
    }
}
