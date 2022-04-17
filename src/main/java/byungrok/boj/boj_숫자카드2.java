package byungrok.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_숫자카드2 {
	static int N, M;
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<Integer, Integer> num = new HashMap<Integer, Integer>();
		
		N = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(!num.containsKey(n)) num.put(n, 1);
			else num.replace(n, num.get(n)+1);
		}
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(!num.containsKey(n)) bw.append(0 + " ");
			else bw.append(num.get(n) + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}