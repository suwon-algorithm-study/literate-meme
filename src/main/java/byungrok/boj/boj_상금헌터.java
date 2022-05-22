package byungrok.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_상금헌터 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		
		int[] score = {0, 500, 300, 200, 50, 30, 10};
		for(int tc=0; tc<TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int total1 = Integer.parseInt(st.nextToken());
			int total2 = Integer.parseInt(st.nextToken());
			
			int rank1 = 0;
			for(int i=1; i<=7; i++) {
				if(total1 <= 0) {
					rank1 = i-1;
					break;
				}
				total1 -= i;
			}
			if(total1 > 0) rank1 = 0;
					
			int rank2 = 0;
			for(int i=0; i<=5; i++) {
				if(total2 <= 0) {
					rank2 = i;
					break;
				}
				total2 -= Math.pow(2, i);
			}
			if(total2 > 0) rank2 = 0;
			
		
			int reward1 = rank1 == 0 ? 0 : score[rank1];
			int reward2 = (int) (rank2 == 0 ? 0 : Math.pow(2, 10-rank2));
			
			bw.append((reward1+reward2)*10000 +"\n");
		}
		bw.flush();
		
		br.close();
		bw.close();
	}
}
