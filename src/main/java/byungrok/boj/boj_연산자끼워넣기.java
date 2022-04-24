package byungrok.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_연산자끼워넣기 {
	static final int OP_SIZE = 4;
	public static void main(String[] args) throws  Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] opCnt = new int[OP_SIZE]; //덧셈, 뺄셈, 곱셈, 나눗셈
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<OP_SIZE; i++) {
			opCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> result = new ArrayList<Integer>();
		permutation(1, N, A, opCnt, A[0], result);
		
		result.sort((a, b) -> a-b);
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));
	}
	private static void permutation(int cnt, int N, int[] A, int[] opCnt, int num, List<Integer> result) {
		if(cnt == N) {
			result.add(num);
			return;
		}
		
		for(int i=0; i<OP_SIZE; i++) {
			if(opCnt[i]==0) continue;
			opCnt[i]--;
			permutation(cnt+1, N, A, opCnt, calC(num, A[cnt],  i), result);
			opCnt[i]++;
		}
	}
	private static int calC(int num1, int num2, int i) {
		int rtv = 0;
		switch (i) {
		case 0: //덧셈
			rtv = num1 + num2;
			break;
		case 1: //뺄셈
			rtv = num1 - num2;
			break;
		case 2: //곱셈
			rtv = num1 * num2;
			break;
		case 3: //나눗셈
			rtv = num1/num2;
			break;
		}
		return rtv;
	}
}
