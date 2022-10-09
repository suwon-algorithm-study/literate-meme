package seojeong.programmers.메뉴리뉴얼;

import java.rmi.server.UnicastRemoteObject;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    static Map<String, Integer> courseMap = new HashMap<>();

    public static void main(String[] args) {

//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course = {2,3,4};

        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2,3,5};

        Solution solution = new Solution();

        solution.solution(orders, course);

    }


    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for (int val: course){
            for(String order:orders){
                String[] temp = order.split("");
                Arrays.sort(temp);
                boolean[] visited = new boolean[temp.length];
                combi(temp,visited,0,val); // course 개수만 큼 뽑기
//                System.out.println();
            }

            List<Map.Entry<String, Integer>> entries = new ArrayList<>(courseMap.entrySet());

            // 내림차순 정렬
            entries.sort((e1, e2) ->
                e2.getValue().compareTo(e1.getValue()));

//            for (Map.Entry<String, Integer> entry : entries) {
//                System.out.println(entry);
//            }

            int max = 0;
            for(Map.Entry<String, Integer> entry:entries){
                if(entry.getValue() > 1 && max <= entry.getValue()){
                    max = entry.getValue();
                    answer.add(entry.getKey());
                }
            }
            courseMap.clear();
        }
        Collections.sort(answer);

        return answer.toArray(String[]::new);
    }
    public void combi(String[] course,boolean[] visited, int depth, int r){
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<course.length; i++){
                if(visited[i]){
                    sb.append(course[i]);
                }
            }
            String key = sb.toString();
            //System.out.println(key);
            //map에 있으면 증가
            if (courseMap.containsKey(key)) {
                courseMap.put(key, courseMap.get(key) + 1);
            } else { //없으면 추가
                courseMap.put(key,1);
            }
            return;
        }
        if(depth == course.length){
            return;
        }
        visited[depth] = true;
        combi(course, visited, depth+1, r-1);

        visited[depth] = false;
        combi(course,visited,depth+1, r);
    }

}
