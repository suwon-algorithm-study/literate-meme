package seojeong.programmers.Baekjoon1461;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 내림 차순
        PriorityQueue<Integer> positive = new PriorityQueue<>((p1,p2)-> p2-p1);
        PriorityQueue<Integer> negative = new PriorityQueue<>((p1,p2)-> p2-p1);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp>0){
                positive.add(temp);
            }
            else{
                negative.add(Math.abs(temp));
            }
        }

        int max_dist = 0;
        // 가장 멀리 있는 책의 위치
        if(positive.isEmpty()){
            max_dist = negative.peek();
        }
        else if(negative.isEmpty()){
            max_dist = positive.peek();
        }
        else{
            max_dist = Math.max(positive.peek(),negative.peek());
        }

        int ans = 0;

        while(!positive.isEmpty()){
            int top = positive.poll();
            for(int i=0; i<m-1; i++){
                positive.poll();
                if(positive.isEmpty()){
                    break;
                }
            }
            ans += top*2;
        }

        while(!negative.isEmpty()){
            int top = negative.poll();
            for(int i=0; i<m-1; i++){
                negative.poll();
                if(negative.isEmpty()){
                    break;
                }
            }
            ans += top*2;
        }

        ans -= max_dist;

        System.out.println(ans);


    }

}
