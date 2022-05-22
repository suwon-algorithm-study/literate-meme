package yeonuk.baekjoon.체스판_다시_칠하기_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.solve();
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }


    public void solve() throws IOException {
        Board board = new Board();

        for (int i = 0; i < board.getX() - 7; i++) {
            for (int j = 0; j < board.getY(i) - 7; j++) {

                //W로 시작
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        int x = i + k;
                        int y = j + l;
                        if (x % 2 == 0 && y % 2 == 0 && board.isBlack(x, y)) {
                            count += 1;
                        } else if (x % 2 == 0 && y % 2 == 1 && board.isWhite(x, y)) {
                            count += 1;
                        } else if (x % 2 == 1 && y % 2 == 0 && board.isBlack(x, y)) {
                            count += 1;
                        } else if (x % 2 == 1 && y % 2 == 1 && board.isWhite(x, y)) {
                            count += 1;
                        }
                    }
                }
                board.updateCount(count);
                System.out.println(count);

                //B로 시작
                count = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        int x = i + k;
                        int y = j + l;
                        if (x % 2 == 0 && y % 2 == 0 && board.isWhite(x, y)) {
                            count += 1;
                        } else if (x % 2 == 0 && y % 2 == 1 && board.isBlack(x, y)) {
                            count += 1;
                        } else if (x % 2 == 1 && y % 2 == 0 && board.isWhite(x, y)) {
                            count += 1;
                        } else if (x % 2 == 1 && y % 2 == 1 && board.isBlack(x, y)) {
                            count += 1;
                        }
                    }
                }
                board.updateCount(count);
                System.out.println(count);
            }
        }

        System.out.println(board.getCount());
    }

    static class Board {
        private final int[][] place;

        private int count;

        public Board() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            place = new int[n][m];
            count = 64;

            for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(br.readLine());
                String line = stk.nextToken();

                for (int j = 0; j < m; j++) {
                    if ('W' == line.charAt(j)) {
                        place[i][j] = 0;
                    } else if ('B' == line.charAt(j)) {
                        place[i][j] = 1;
                    } else {
                        place[i][j] = -1;
                    }
                }
            }

            br.close();
        }

        public int getX() {
            return place.length;
        }

        public int getY(int x) {
            return place[x].length;
        }

        public int getColor(int x, int y) {
            return place[x][y];
        }

        public boolean isWhite(int x, int y) {
            return getColor(x, y) == 0;
        }

        public boolean isBlack(int x, int y) {
            return getColor(x, y) == 1;
        }

        public void updateCount(int count) {
            if (count != 0) {
                this.count = Math.min(this.count, count);
            }
        }

        public int getCount() {
            return count;
        }
    }

}
