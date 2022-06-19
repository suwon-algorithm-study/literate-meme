package jian.programmers.뉴스클러스터링_17677;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution("aaa", "baaaa");
	}

	public int solution(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		List<String> str1List = getElement(str1);
		List<String> str2List = getElement(str2);

		int result = jacquard(str1List, str2List);

		return result;
	}
	

	public List<String> getElement(String str) {
		List<String> strList = new ArrayList<String>();

		for (int i = 0; i < str.length() - 1; i++) {
			int str1Num = (int) str.charAt(i);
			int str2Num = (int) str.charAt(i + 1);

			if ((64 < str1Num && str1Num < 91) || (96 < str1Num && str1Num < 123)) {
				if ((64 < str2Num && str2Num < 91) || (96 < str2Num && str2Num < 123)) {

					strList.add(String.valueOf((char) str1Num).concat(String.valueOf((char) str2Num)));
				}
			}
		}

		return strList;
	}

	public int jacquard(List<String> str1List, List<String> str2List) {
		if (str1List.size() == 0 && str2List.size() == 0) {
			return 1 * 65536;
		}
		
		int str1min = 0;
		int str2min = 0;
		
		// [AA, AA]
		// [AA, AA, AA]
		
		for (int i = 0; i < str1List.size(); i++) { 
			for (int j = 0; j < str2List.size(); j++) { 
				if (str1List.get(i).equals(str2List.get(j))) { 
					str1min++;
					break; 
				} 
			} 
		}
		
		for (int i = 0; i < str2List.size(); i++) { 
			for (int j = 0; j < str1List.size(); j++) { 
				if (str2List.get(i).equals(str1List.get(j))) { 
					str2min++; 
					break; 
				}
			} 
		}
		
		int min = Math.min(str1min, str2min);
		int max = str1List.size() + str2List.size() - min;
		
		double result = (double) min / max;
		
		return (int) (result * 65536);
	}
}
