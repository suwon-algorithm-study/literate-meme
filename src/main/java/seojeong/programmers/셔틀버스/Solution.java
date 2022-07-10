package seojeong.programmers.셔틀버스;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

        String answer = solution(1,1,5,new String[]{"08:00", "08:01", "08:02", "08:03"});
        System.out.println(answer);

    }
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String s : timetable) {
            int time = Integer.parseInt(s.substring(0,2)) * 60 + Integer.parseInt(s.substring(3));
            pq.add(time);
        }
        int start_time = 9*60;
        int last_time = 0;

        int total = 0;
        for(int i=0; i<n; i++){
            total = 0;
            while(!pq.isEmpty()){
                int currentTime = pq.peek();
                if(currentTime <= start_time && total < m){
                    pq.poll();
                    total++;
                }else{
                    break;
                }
                last_time = currentTime - 1;
            }
            start_time += t;
        }
        if(total < m){
            last_time = start_time - t;
        }
        String hour = String.format("%02d", last_time/60);
        String minute = String.format("%02d", last_time % 60);
        return hour + ":" + minute;
    }

}
