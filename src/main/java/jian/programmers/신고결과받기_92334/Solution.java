package jian.programmers.신고결과받기_92334;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
	
//	String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//	String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//	int k = 2;

//	public static void main(String[] args) throws IOException {
//		Solution solution = new Solution();
		
//		System.out.println(solution.solution());
//	}
	
	public int[] solution(String[] id_list, String[] report, int k) {
//	public int[] solution() {
		
		List<Map<String, String>> rpList = new ArrayList<Map<String,String>>();
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		// 0. 신고당한 횟수를 저장하는 map 초기화
		for (int i = 0; i < id_list.length; i++) {
			map.put(id_list[i], 0);
		}

		Map<String, Integer> rsMap = new LinkedHashMap<String, Integer>(map);

		// 1. map에 이용자가 몇 번 신고당했는지 저장
		for (int j = 0; j < report.length; j++) {
			StringTokenizer st = new StringTokenizer(report[j]);

			// 신고한 사람, 신고당한 사람 list
			String user     = st.nextToken();
			String reported = st.nextToken();
			
			Map<String, String> tMap = new HashMap<>();
			tMap.put(user, reported);
			
			rpList.add(tMap);
			
			rpList = rpList.stream()
						.distinct()
						.collect(Collectors.toList());
		}
		
		for (int r = 0; r < rpList.size(); r++) {
			for (Entry<String, String> e : rpList.get(r).entrySet()) {
				int value = map.get(e.getValue());
				map.put(e.getValue(), value+1);
			}
		}
		
		// 2. 신고당한 횟수가 k 이상인 이용자 찾기
		Object[] overUser = map.entrySet().stream()
				.filter(e -> e.getValue() >= k)
				.map(Map.Entry::getKey)
				.toArray();
		
		// 3. overUser를 신고한 이용자 찾기 ex. [frodo, neo]
		for (int z = 0; z < overUser.length; z++) {
			for (int x = 0; x < rpList.size(); x++) {
				for (Entry<String, String> e : rpList.get(x).entrySet()) {
					if (e.getValue().equals(overUser[z])) {
						int value = rsMap.get(e.getKey());
						rsMap.put(e.getKey(), value+1);
					}
				}
			}
		}
		
		int[] answer = rsMap.entrySet().stream()
						.mapToInt(Map.Entry::getValue)
						.toArray();
		
		return answer;
	}
	
}