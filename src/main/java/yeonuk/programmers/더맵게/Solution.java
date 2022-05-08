package yeonuk.programmers.더맵게;

import java.util.PriorityQueue;

public class Solution {


    public static void main(String[] args) {
        int k = 7;
        int [] scoville = {1, 2, 3};

        Solution solution = new Solution();
        int answer = solution.solution(scoville, k);
        System.out.println(answer);
    }

    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> scovilles = new PriorityQueue<>();
        for (int score : scoville) {
            scovilles.add(score);
        }

        int answer = 0;
        while (scovilles.peek() < k) {
            if (scovilles.size() < 2) {
                answer = -1;
                break;
            }

            answer++;

            int first = scovilles.poll();
            int second = scovilles.poll();

            int result = first + second * 2;

            scovilles.add(result);
        }

        return answer;
    }
}

