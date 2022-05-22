package byungrok.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_체스판다시칠하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		
		for(int i=0; i<N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i+8 > N || j+8>M) continue;
				
				min = Math.min(min, getCnt(i, j, board));
			}
		}
		
		System.out.println(min);
	}

	private static int getCnt(int y, int x, char[][] board) {
		char pivot = board[y][x];
		int cnt = 0;
		
		for(int i=y; i<y+8; i++) {
			for(int j=x; j<x+8; j++) {
				if((i+j)%2 == 0 && pivot != board[i][j]) cnt++;
				else if((i+j)%2 != 0 && pivot == board[i][j]) cnt++;
			}
		}
		return Math.min(cnt, 64-cnt);
	}
}
