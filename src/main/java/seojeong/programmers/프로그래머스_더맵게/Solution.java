package seojeong.programmers.프로그래머스_더맵게;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] arg){
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;

        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int val:scoville){
            pq.offer(val);
        }
        while(pq.peek()<K){
            if(pq.size() == 1){
                System.out.println(-1);
            }
            int a = pq.poll();
            int b = pq.poll();
            int result = a + b*2;
            pq.offer(result);
        }
        System.out.println(answer);
    }
}
