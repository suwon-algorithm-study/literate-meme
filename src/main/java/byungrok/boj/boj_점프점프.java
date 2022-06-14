package byungrok.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_점프점프 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		int[] map = new int[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 0;
		while(st.hasMoreTokens()) {
			map[idx++] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[size];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		q.offer(new int[] {0, 0});
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int step = map[temp[0]];
			for(int i=1; i<=step; i++) {
				int next = temp[0] + i;
				if(next >= size || dp[next] <= temp[1]+1) break;
				dp[next] = temp[1]+1;
				q.offer(new int[] {next, temp[1]+1});
			}
		}
		System.out.println(dp[size-1] == Integer.MAX_VALUE ? -1 : dp[size-1]);
	}
}
