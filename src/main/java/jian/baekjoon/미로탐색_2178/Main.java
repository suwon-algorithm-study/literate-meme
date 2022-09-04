package jian.baekjoon.미로탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        solution.solve();
    }

    static int[][] arr;
    static int[][] visited;

    public void solve() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = (int) row.charAt(j) - 48;
            }
        }

        System.out.println(bfs(0, 0));
    }

    public int bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        visited[i][j] = 1;

        int result = 1;

        while (!queue.isEmpty()) {
            for (int n = 0; n < queue.size(); n++) {
                i = queue.peek().getX();
                j = queue.peek().getY();

                if (i == arr.length - 1 && j == arr[0].length - 1) {
                    return result;
                }

                queue.poll();

                if (valid(i - 1, j) && arr[i - 1][j] == 1 && visited[i - 1][j] == 0) {
                    queue.add(new Pair(i - 1, j));
                    visited[i - 1][j] = 1;
                }

                if (valid(i, j - 1) && arr[i][j - 1] == 1 && visited[i][j - 1] == 0) {
                    queue.add(new Pair(i, j - 1));
                    visited[i][j - 1] = 1;
                }

                if (valid(i, j + 1) && arr[i][j + 1] == 1 && visited[i][j + 1] == 0) {
                    queue.add(new Pair(i, j + 1));
                    visited[i][j + 1] = 1;
                }

                if (valid(i + 1, j) && arr[i + 1][j] == 1 && visited[i + 1][j] == 0) {
                    queue.add(new Pair(i + 1, j));
                    visited[i + 1][j] = 1;
                }
            }
            result++;
        }

        return result;
    }

    public boolean valid(int y, int z) {
        if ((y >= 0 && y < arr.length) && (z >= 0 && z < arr[0].length)) {
            return true;
        }
        return false;
    }

    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
