package yeonuk.programmers.짝지어_제거하기;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int solution(String input) {
        Deque<Character> inputs = new ArrayDeque<>();
        inputs.addLast(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (!inputs.isEmpty() && inputs.getLast().equals(input.charAt(i))) {
                inputs.removeLast();
            } else {
                inputs.addLast(input.charAt(i));
            }
        }

        return inputs.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("baabaa");

        System.out.println(result);
    }
}
