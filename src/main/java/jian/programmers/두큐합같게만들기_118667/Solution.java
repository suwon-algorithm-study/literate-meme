package jian.programmers.두큐합같게만들기_118667;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] queue1 = {1, 1, 1, 1, 1};
        int[] queue2 = {1, 1, 1, 9, 1};
        System.out.println(sol.solution(queue1, queue2));
    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long tot1 = 0, tot2 = 0;

        Queue<Long> que1 = new LinkedList<>();
        Queue<Long> que2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            que1.add((long) queue1[i]);
            que2.add((long) queue2[i]);

            tot1 += queue1[i];
            tot2 += queue2[i];
        }
        /*Queue<Long> orgQue1 = new LinkedList<>(que1);
        Queue<Long> orgQue2 = new LinkedList<>(que2);*/

        while (tot1 != tot2) {
            /*if (orgQue1.equals(que2) && orgQue2.equals(que1)) {
                return answer = -1;
            }*/

            if (answer >= (queue1.length + queue2.length) * 2) {
                return answer = -1;
            }

            if (tot1 < tot2) {
                long element = (long) que2.poll();
                que1.add(element);
                tot1 += element;
                tot2 -= element;

            } else {  // tot1 > tot2
                long element = (long) que1.poll();
                que2.add(element);
                tot2 += element;
                tot1 -= element;
            }

            answer++;
        }

        return answer;
    }
}
