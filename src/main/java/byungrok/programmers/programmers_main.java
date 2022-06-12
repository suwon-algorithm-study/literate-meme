package byungrok.programmers;

public class programmers_main {
	public static void main(String[] args) {
		programmers_키패드_누르기 s = new programmers_키패드_누르기();
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(s.solution(numbers, hand));
	}
}
