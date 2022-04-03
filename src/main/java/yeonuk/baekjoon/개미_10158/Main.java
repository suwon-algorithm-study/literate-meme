package yeonuk.baekjoon.개미_10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Location result = main.solve();

        System.out.println(result.getP() + " " + result.getQ());
    }

    public Location solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(stk.nextToken());

        Location location = new Location(p, q, w, h);

        for (int i = 0; i < t % (w * 2); i++) {
            if (location.isChangeRowDirection()) {
                location.changeRowDirection();
            }

            location.moveX();
        }

        for (int i = 0; i < t % (h * 2); i++) {
            if (location.isChangeColumnDirection()) {
                location.changeColumnDirection();
            }

            location.moveY();
        }

        return location;
    }

    private static class Direction {

        private int x;
        private int y;

        public Direction() {
            this.x = 1;
            this.y = 1;
        }

        public void changeRowDirection() {
            this.x *= -1;
        }

        public void changeColumnDirection() {
            this.y *= -1;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private static class Location {

        private int p;
        private int q;
        private final int w;
        private final int h;
        private Direction direction;

        public Location(int p, int q, int w, int h) {
            this.p = p;
            this.q = q;
            this.w = w;
            this.h = h;
            this.direction = new Direction();
        }

        public boolean isChangeRowDirection() {
            return this.p == 0 || this.p == w;
        }

        public boolean isChangeColumnDirection() {
            return this.q == 0 || this.q == h;
        }

        public void moveX() {
            this.p += direction.getX();
        }

        public void moveY() {
            this.q += direction.getY();
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }

        public int getW() {
            return w;
        }

        public int getH() {
            return h;
        }

        public void changeRowDirection() {
            this.direction.changeRowDirection();
        }

        public void changeColumnDirection() {
            this.direction.changeColumnDirection();
        }
    }
}


/**
 * y축 -> x * -1
 * x축 -> y * -1
 */