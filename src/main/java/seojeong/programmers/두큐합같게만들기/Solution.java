package seojeong.programmers.두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(new int[]{3,2,7,2},new int[]{4,6,5,1}));

    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1=0,sum2 = 0;
        // 전체 합 구하기
        for(int val:queue1){
            q1.offer(val);
            sum1 += val;
        }
        for(int val:queue2){
            q2.offer(val);
            sum2 += val;
        }
        // sum1 -> queue1 전체 합, sum2 -> queue2 전체 합
        // return을 언제? 아예 안되는 상황을 어떻게 찾지,,,
        int count = 0;
        while(sum1 != sum2){
            count++;
            if(sum1 > sum2){
                int temp = q1.poll();
                sum1 -= temp;
                sum2 += temp;
                q2.offer(temp);
            }else{
                int temp = q2.poll();
                sum1 += temp;
                sum2 -= temp;
                q1.offer(temp);
            }

            if(count > (queue1.length+queue2.length)*2) return -1;
        }
        answer = count;
        return answer;
    }
}
