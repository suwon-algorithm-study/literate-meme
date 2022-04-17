package byungrok.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_신입사원 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			int[] newEmployee = new int[N+1]; // 0  - 서류, 1- 면접
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				newEmployee[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			
			int min = Integer.MAX_VALUE, result=0;
			for(int i=1; i<=N; i++) {
				if(newEmployee[i] < min) {
					result++; min = newEmployee[i];
				}
			}
			System.out.println(result);
		}
	}
}
