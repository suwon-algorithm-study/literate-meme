package jieun.programmers.성격유형검사하기;
import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        setMap(map);

        for(int i = 0; i < survey.length; i++) {
            int point = choices[i];
            String[] keys = survey[i].split("");

            if(point == 4) { break; }

            int idx = point < 4 ? 0 : 1;
            int temp = map.get(keys[idx]);
            map.replace(keys[idx], temp+=point-4);
        }

        return setAnswer(map);
    }

    public void setMap(HashMap<String, Integer> map) {
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
    }

    public String setAnswer(HashMap<String, Integer> map){
        String answer = "";
        answer += map.get("R") >= map.get("T") ? "R" : "T";
        answer += map.get("C") >= map.get("F") ? "C" : "F";
        answer += map.get("J") >= map.get("M") ? "J" : "M";
        answer += map.get("A") >= map.get("N") ? "A" : "N";
        return answer;
    }
}
