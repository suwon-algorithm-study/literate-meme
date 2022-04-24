package byungrok.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_N과M2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N;
		int M;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N+1];
		permutation(0, 0, N, M, visited, "", bw);
		
		bw.flush();
		br.close();
		bw.close();
	}

	private static void permutation(int start, int cnt, int N, int M, boolean[] visited, String result, BufferedWriter bw) throws IOException {
		if(cnt == M) {
			//종료 조건
			bw.append(result);
			bw.newLine();
			return;
		}
		
		for(int i=start+1; i<=N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			permutation(i, cnt+1, N, M, visited, "".equals(result) ? result+i :result + " " + i, bw);
			visited[i] = false;
		}
	}
}
