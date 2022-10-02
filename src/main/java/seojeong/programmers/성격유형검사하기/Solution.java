package seojeong.programmers.성격유형검사하기;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String answer= solution.solution(survey,choices);
        System.out.println(answer);

    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<String, Integer> total = new HashMap<>();
        // R,T / C,F / J,M / A,N
        String[] character = {"R","T","C","F","J","M","A","N"};
        int[] scores = {3,2,1,0,1,2,3};

        for(String val: character){
            total.put(val,0);
        }
        for(int i=0; i<survey.length; i++){
            String[] temp = survey[i].split("");
            int idx = choices[i]-1; // 인덱스 3 미만이면 앞의 성격유형에 카운트
            int score = scores[idx];

            if(idx < 3){
                int before = total.get(temp[0]);
                total.put(temp[0],before + score); // 점수 업데이트
            }else if(idx == 3){
                continue;
            }else{
                int before = total.get(temp[1]);
                total.put(temp[1],before + score);
            }
        }

        for(int i=0; i< character.length; i+=2){
            String category1 = character[i];
            String category2 = character[i+1];

            if(total.get(category1) < total.get(category2)){
                answer += category2;
            }else if(total.get(category1) > total.get(category2)){
                answer += category1;
            }else{
                if(category1.compareTo(category2) > 0){
                    answer += category2;
                }else{
                    answer += category1;
                }
            }
        }
        /*
        for (Map.Entry<String, Integer> stringIntegerEntry : total.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() +" " + stringIntegerEntry.getValue());
        }
         */

        return answer;
    }
}
