package byungrok.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_도서관 {
	static Integer N, M, result, sign;
	static List<Integer> positive, negative;
	static final int START = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		positive = new ArrayList<Integer>();
		negative = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num < 0) negative.add(num);
			else positive.add(num);
		}
		
		Collections.sort(negative);
		Collections.sort(positive, Collections.reverseOrder());
		
		sign = 1;
		if(negative.isEmpty()) sign = 1;
		else if(positive.isEmpty()) sign = -1;
		else if(Math.abs(negative.get(0)) > Math.abs(positive.get(0))) sign = -1;
		
		result = 0;
		result += getDistance(positive, sign == 1);
		result += Math.abs(getDistance(negative, sign == -1));
		
		System.out.println(result);
	}
	private static Integer getDistance(List<Integer> list, boolean flag) {
		int sum = 0;
		for(int i=0; i<list.size(); i+=M) {
			if(flag && i==0) sum+=list.get(i);
			else {
				sum += list.get(i)*2;
			}
		}
		return sum;
	}
}
