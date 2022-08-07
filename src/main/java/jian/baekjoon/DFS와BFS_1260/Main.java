package jian.baekjoon.DFS와BFS_1260;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        solution.solve();
    }

    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static BufferedWriter bw;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());

            int prevNode = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());

            graph.get(prevNode).add(nextNode);
            graph.get(nextNode).add(prevNode);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];
        dfs(v);
        bw.newLine();

        visited = new boolean[n + 1];
        bfs(v);

        bw.flush();
        bw.close();
    }

    public void dfs(int v) throws IOException {
        visited[v] = true;
        bw.write(v + " ");

        for (int node : graph.get(v)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    public void bfs(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        bw.write(v + " ");

        while (!queue.isEmpty()) {
            int value = queue.poll();

            for (int node : graph.get(value)) {
                if (!visited[node]) {
                    queue.add(node);
                    visited[node] = true;

                    bw.write(node + " ");
                }
            }
        }
    }
}
