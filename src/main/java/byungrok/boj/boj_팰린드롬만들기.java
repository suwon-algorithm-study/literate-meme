package byungrok.boj;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj_팰린드롬만들기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Map<Character, Integer> cnt = new HashMap<Character, Integer>();
		for(char c : str.toCharArray()) {
			if(cnt.containsKey(c)) {
				cnt.replace(c, cnt.get(c)+1);
			}else {
				cnt.put(c, 1);
			}
		}
		
		char remainOne = 0;
		boolean flag = false;
		String answer = "";
		for(char c = 'A'; c<='Z'; c++) {
			if(!cnt.containsKey(c)) continue;
			int num = cnt.get(c);
			if(num%2 != 0) {
				if(remainOne != 0) {
					flag = true;
					break;
				}
				remainOne = c;
			}
			answer += (""+c).repeat(num/2);
		}
		StringBuffer sb = new StringBuffer(answer);
		if(remainOne != 0) answer += remainOne;
		answer+=sb.reverse();
		System.out.println(flag ? "I'm Sorry Hansoo" : answer);
	}
}
