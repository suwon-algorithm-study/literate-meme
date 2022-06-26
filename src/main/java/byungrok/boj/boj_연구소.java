package byungrok.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_연구소 {
	private static List<int[]> safeZone;
	private static List<int[]> virus;
	private static int min;

	public static void main(String[] args) throws Exception {
		Input_연구소 input = new Input_연구소();
		input.init();

		solution(input.getN(), input.getM(), input.getMap());
	}

	private static void solution(int n, int m, int[][] map) {
		// 1. 안전지역, 바이러스 집합 구하기
		safeZone = new ArrayList<int[]>();
		virus = new ArrayList<int[]>();
		setList(n, m, map);

		// 2. safeZone에서 벽 3개 올리는 경우의 수
		min = Integer.MAX_VALUE;
		combi(0, 0, n, m, map);

		System.out.println(safeZone.size() - 3 - min);
	}

	private static void combi(int depth, int idx, int n, int m, int[][] map) {
		if (depth == 3) {
			// 종료조건
			// 세균을 퍼뜨려본다.
			min = Math.min(min, spreadVirus(n, m, map));
			return;
		}

		for (int i = idx; i < safeZone.size(); i++) {
			int[] pos = safeZone.get(i);
			map[pos[0]][pos[1]] = 1;
			combi(depth + 1, i + 1, n, m, map);
			map[pos[0]][pos[1]] = 0;
		}
	}

	private static int spreadVirus(int n, int m, int[][] map) {
		// bfs
		int count = 0;
		int[] dy = { -1, 0, 1, 0 }, dx = { 0, -1, 0, 1 };

		Queue<int[]> q = new LinkedList<int[]>();
		for (int[] v : virus) {
			q.offer(v);
		}
		boolean[][] visited = new boolean[n][m];

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = pos[0] + dy[d];
				int nx = pos[1] + dx[d];
				if (isOut(ny, nx, n, m) || map[ny][nx] != 0 || visited[ny][nx])
					continue;
				visited[ny][nx] = true;
				count++;
				if (min <= count)
					return count;
				q.offer(new int[] { ny, nx });
			}
		}

		return count;
	}

	private static boolean isOut(int y, int x, int n, int m) {
		return y < 0 || y >= n || x < 0 || x >= m;
	}

	private static void setList(int n, int m, int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					safeZone.add(new int[] { i, j });
				} else if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
	}
}

class Input_연구소 {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private int N;
	private int M;
	private int[][] map;

	public int getN() {
		return N;
	}

	public int getM() {
		return M;
	}

	public int[][] getMap() {
		return map;
	}

	public void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
