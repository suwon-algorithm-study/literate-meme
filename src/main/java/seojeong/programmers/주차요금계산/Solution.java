package seojeong.programmers.주차요금계산;

import java.util.*;


public class Solution {



    public static void main(String[] args){
        int[] fees = {180, 5000, 10, 60};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] answer = {};
        //<차량 번호, 입장 시간>
        Map<Integer,Integer> startTime = new HashMap<>();
        //<차량 번호, 최종 이용 시간>
        Map<Integer, Integer> totalTime = new HashMap<>();
        // 입차 차량 정보
        Set<Integer> carIn = new HashSet<>();

        for(String record:records){
            String[] temp = record.split(" ");
            int time = calTime(temp[0]);
            Integer carNum = Integer.parseInt(temp[1]);

            //입차 처리
            if(!startTime.containsKey(carNum)){
                carIn.add(carNum);
                startTime.put(carNum,time);
                //처음 입차되는 차량
                if(!totalTime.containsKey(carNum)){
                    totalTime.put(carNum, 0);
                }
            }else{ //출차 처리
                totalTime.put(carNum, totalTime.get(carNum) + time - startTime.get(carNum));
                startTime.remove(carNum);
            }

        }

        //입차는 했는데 출차되지 않은 차량들 처리
        for(Integer key:startTime.keySet()){
            totalTime.put(key, totalTime.get(key) + 1439 - startTime.get(key));
        }
        List<Integer> list = new ArrayList<>(carIn);
        Collections.sort(list);

        answer = new int[carIn.size()];

        //fees =[기본시간(분), 기본요금(원), 단위시간(분), 단위요금(원)]
        int idx = 0;
        for (int num : list) {
            int time = totalTime.get(num);
            if (time <= fees[0]) {
                answer[idx] = fees[1];
            } else {
                answer[idx] = (int) (fees[1] + Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3]);
            }
            idx++;
        }
        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }


    public static int calTime(String time){
        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]) * 60;
        int min = Integer.parseInt(temp[1]);

        return hour + min;
    }
}


