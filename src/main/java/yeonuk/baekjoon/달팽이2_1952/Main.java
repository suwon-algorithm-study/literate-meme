package yeonuk.baekjoon.달팽이2_1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try {
            Input input = new Input();
            input.init();

            Main main = new Main();
            main.solve(input);
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }


    public void solve(Input input) {
        SnailMap snailMap = new SnailMap(input.getN(), input.getM());
        Snail snail = new Snail();
        Direction direction = new Direction();

        while (true) {
            if (snailMap.visited(snail.getNextX(direction.getDx()), snail.getNextY(direction.getDy()))) {
                direction.turn();
                snailMap.turnCountUp();

                continue;
            }

            snail.move(direction.getDx(), direction.dy);
            snailMap.arrive(snail.getX(), snail.getY());

            if (snailMap.isFinish()) {
                System.out.println(snailMap.getTurnCount());
                break;
            }

            if (snailMap.isEdge(snail.getX(), snail.getY())) {
                direction.turn();
                snailMap.turnCountUp();
            }
        }
    }

    static class Snail {

        private int x;
        private int y;

        public Snail() {
            this.x = 0;
            this.y = 0;
        }

        public void move(int dx, int dy) {
            this.x += dx;
            this.y += dy;
        }

        public int getNextX(int dx) {
            return this.x + dx;
        }

        public int getNextY(int dy) {
            return this.y + dy;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static class SnailMap {

        private int[][] map;

        private final int n;
        private final int m;

        private int turnCount;

        public SnailMap(int n, int m) {
            this.n = n;
            this.m = m;

            this.map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    this.map[i][j] = 0;
                }
            }
            this.map[0][0] = 1;

            this.turnCount = 0;
        }

        public boolean visited(int x, int y) {
            return this.map[x][y] == 1;
        }

        public void arrive(int x, int y) {
            this.map[x][y] = 1;
        }

        public boolean isEdge(int x, int y) {
            if (x == n - 1 && y == 0) {
                return true;
            } else if (x == n - 1 && y == m - 1) {
                return true;
            } else if (x == 0 && y == m - 1) {
                return true;
            } else if (x == 0 && y == 0) {
                return true;
            } else {
                return false;
            }
        }

        public void turnCountUp() {
            this.turnCount += 1;
        }

        public boolean isFinish() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (this.map[i][j] == 0) {
                        return false;
                    }
                }
            }
            return true;
        }

        public int getTurnCount() {
            return turnCount;
        }
    }

    static class Direction {

        private int dx;

        private int dy;

        public Direction() {
            dx = 1;
            dy = 0;
        }

        public void turn() {
            if (dx > 0 && dy == 0) {
                dx = 0;
                dy = 1;
            } else if (dx == 0 && dy > 0) {
                dx = -1;
                dy = 0;
            } else if (dx < 0 && dy == 0) {
                dx = 0;
                dy = -1;
            } else if (dx == 0 && dy < 0) {
                dx = 1;
                dy = 0;
            } else {
                throw new IllegalStateException();
            }
        }

        public int getDx() {
            return dx;
        }

        public int getDy() {
            return dy;
        }
    }

    static class Input {

        private int n;
        private int m;

        public void init() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            m = Integer.parseInt(stk.nextToken());
            n = Integer.parseInt(stk.nextToken());

            br.close();
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }
    }
}
