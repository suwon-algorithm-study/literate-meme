package jian.programmers.키패드누르기_67256;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String answer = sol.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
		System.out.println(answer);
	}

	public String solution(int[] numbers, String hand) {
		int prevL = 10;
		int prevR = 12;

		String answer = "";

		for (int number : numbers) {
			if (number == 1 || number == 4 || number == 7) {
				prevL = number;
				answer += "L";

			} else if (number == 3 || number == 6 || number == 9) {
				prevR = number;
				answer += "R";

			} else {
				int leftInstance = getInstance(number, prevL);
				int rigtInstance = getInstance(number, prevR);

				if (leftInstance == rigtInstance) {
					if ("left".equals(hand)) {
						prevL = number;
						answer += "L";
					} else {
						prevR = number;
						answer += "R";
					}

				} else if (leftInstance < rigtInstance) {
					answer += "L";
					prevL = number;
				} else {
					answer += "R";
					prevR = number;
				}
			}
		}

		return answer;
	}

	public int getInstance(int number, int prev) {
		if (number == 0) number = 11;

		if (prev == 0) prev = 11;

		int row = Math.abs(number - prev) / 3;
		int col = Math.abs(number - prev) % 3;

		return row + col;
	}

}