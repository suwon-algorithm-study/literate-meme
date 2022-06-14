package byungrok.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class boj_회문 {
	public static void main(String[] args) throws IOException {
		Input_회문 input = new Input_회문();
		input.init();
		
		int rtv[] = solution(input.getTestCase(), input.getWords());
		
		Output_회문 output = new Output_회문();
		output.print(rtv);
	}

	private static int[] solution(int testCase, String[] words) {
		int[] answer = new int[testCase];
		int idx =0;
		for(String word : words) {
			Queue<int[]> q = new LinkedList<int[]>();
			char[] cArray = word.toCharArray();
			
			
			q.offer(new int[] {0, cArray.length-1, 0});
			
			int min = 2;
			while(!q.isEmpty()) {
				int[] data = q.poll();
				
				int cnt = data[2];
				int lIdx = data[0];
				int rIdx = data[1];
				 
				if(lIdx >= rIdx) {
					min = Math.min(min, cnt);
					continue;
				}
				
				while(lIdx < rIdx) {
					if(cArray[lIdx] != cArray[rIdx]) {
						cnt++;
						if(cnt == 2) break;
						
						if(cArray[lIdx+1] == cArray[rIdx]) {
							q.offer(new int[] {lIdx+1, rIdx, cnt});
						}
						if(cArray[lIdx] == cArray[rIdx-1]) {
							q.offer(new int[] {lIdx, rIdx-1, cnt});
						}
						break;
					}
					lIdx++;
					rIdx--;
				}
				if(cnt<2) {
					q.offer(new int[] {lIdx, rIdx, cnt});
				}
			}
			
			answer[idx++] = min;
		}
		
		return answer;
	}
	
	
}
class Input_회문{
	private int testCase;
	private String[] words;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void init() throws IOException{
		
		testCase = Integer.parseInt(br.readLine());
		words = new String[testCase];
		
		for(int i=0; i<testCase; i++) {
			words[i] = br.readLine();
		}
	}

	public int getTestCase() {
		return testCase;
	}

	public String[] getWords() {
		return words;
	}
}

class Output_회문{
	private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public void print(int[] numbers) throws IOException{
		for(int number : numbers) {
			bw.append(number+"\n");
		}
		bw.flush();
	}
}
