package jian.programmers.신고결과받기_92334;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public int[] solution(String[] id_list, String[] report, int k) {
		// 중복 제거한 [신고한 유저]-[신고당한 유저] 배열
		report = Arrays.asList(report).stream()
				.distinct().toArray(String[]::new);

		List<User> user_list = new ArrayList<Solution.User>();

		for (int u = 0; u < id_list.length; u++) {
			User user = new User();
			user.setUser(id_list[u]);
			user_list.add(user);
		}

		for (int i = 0; i < report.length; i++) {
			StringTokenizer st = new StringTokenizer(report[i]);

			String userId   = st.nextToken();
			String reported = st.nextToken();

			for (User userE : user_list) {
				if (userE.getUser().equals(userId)) {
					userE.addReportedId(reported);
				}

				if (userE.getUser().equals(reported)) {
					userE.addReportedCnt();
				}
			}
		}

		// k번 이상 신고당한 사람 찾기
		user_list.forEach(e -> {
			if (e.getReportedCnt() >= k) {
				for (User userE : user_list) {
					if (userE.getReportedId().contains(e.getUser())) {
						userE.sendMail();
					}
				}

			}
		});

		int[] answer = new int[user_list.size()];

		for (int z = 0; z < user_list.size(); z++) {
			answer[z] = user_list.get(z).getReceivedMail();
		}

		return answer;
	}

	class User {
		String user;
		List<String> reported_list = new ArrayList<String>();
		int reported_cnt  = 0;
		int received_mail = 0;

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public List<String> getReportedId() {
			return reported_list;
		}

		public void addReportedId(String reported_id) {
			this.reported_list.add(reported_id);
		}

		public int getReportedCnt() {
			return reported_cnt;
		}

		public void addReportedCnt() {
			this.reported_cnt++;
		}

		public int getReceivedMail() {
			return received_mail;
		}

		public void sendMail() {
			this.received_mail++;
		}
	}
}