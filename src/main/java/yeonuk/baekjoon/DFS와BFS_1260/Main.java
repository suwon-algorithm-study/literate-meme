package yeonuk.baekjoon.DFS와BFS_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try {
            Input input = new Input();
            input.init();

            Solution solution = new Solution(input);
            solution.solve();
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }
}

class Solution {

    private final int[] dfsHistories;
    private final int[] bfsHistories;

    private final int[][] edges;

    private final int startNode;

    private final StringBuilder stringBuilder;

    public Solution(Input input) {
        dfsHistories = new int[input.getN()];
        bfsHistories = new int[input.getN()];
        edges = new int[input.getN()][input.getN()];

        for (int i = 0; i < input.getN(); i++) {
            System.arraycopy(input.getValues()[i], 0, edges[i], 0, input.getN());
        }

        startNode = input.getV() - 1;
        stringBuilder = new StringBuilder();
    }

    public void solve() {
        dfs(startNode);
        stringBuilder.append("\n");

        bfs(startNode);
        System.out.println(stringBuilder.toString());
    }

    private void dfs(int node) {
        dfsHistories[node] = 1;
        stringBuilder.append(node + 1);
        stringBuilder.append(" ");

        for (int i = 0; i < edges.length; i++) {
            if (edges[node][i] == 1 && dfsHistories[i] == 0) {
                dfs(i);
            }
        }
    }

    private void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        bfsHistories[startNode] = 1;

        while (!queue.isEmpty()) {
            Integer nextNode = queue.poll();
            stringBuilder.append(nextNode + 1);
            stringBuilder.append(" ");

            for (int i = 0; i < edges.length; i++) {
                if (edges[nextNode][i] == 1 && bfsHistories[i] == 0) {
                    queue.offer(i);
                    bfsHistories[i] = 1;
                }
            }
        }
    }
}

class Input {

    private int n;
    private int m;

    private int v;

    private int[][] values;

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        v = Integer.parseInt(stk.nextToken());
        values = new int[n][n];

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(stk.nextToken());
            int second = Integer.parseInt(stk.nextToken());

            values[first - 1][second - 1] = 1;
            values[second - 1][first - 1] = 1;
        }

        br.close();
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getV() {
        return v;
    }

    public int[][] getValues() {
        return values;
    }
}
