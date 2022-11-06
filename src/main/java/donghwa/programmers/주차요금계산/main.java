import java.util.*;

class Solution {
  public int[] solution(int[] fees, String[] records) {
    int[] answer;
    ArrayList<Integer> ans = new ArrayList<>();
    int maxTime = 1439;
    boolean[] check = new boolean[10000];
    Map<String, Integer> map = new TreeMap<>();
    for (int i = 0; i < records.length; i++) {
      String[] record = records[i].split(" ");
      String[] record_time = record[0].split(":");
      int record_minutes = Integer.parseInt(record_time[0]) * 60 + Integer.parseInt(record_time[1]);
      if (record[2].equals("IN")) {
        if (map.get(record[1]) != null) {
          int past = map.get(record[1]);
          map.put(record[1], past + record_minutes * (-1));
        } else {
          map.put(record[1], record_minutes * (-1));
        }
      } else {
        int past_record_minutes = map.get(record[1]);
        map.put(record[1], record_minutes + past_record_minutes);
      }
    }

    for (String k : map.keySet()) {
      int v = map.get(k);
      if (v <= 0) {
        int v2 = maxTime + v;
        ans.add(finalCost(v2, fees));
      } else {
        ans.add(finalCost(v, fees));
      }
    }

    answer = new int[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      answer[i] = ans.get(i);
    }
    return answer;
  }

  int finalCost(int parkingTime, int[] fees) {
    if (parkingTime < fees[0]) {
      return fees[1];
    } else {
      int cost1 = fees[1];
      float restTime = parkingTime - fees[0];
      int restTime2 = (int) Math.ceil(restTime / fees[2]);
      int cost3 = restTime2 * fees[3] + fees[1];
      return cost3;
    }
  }
}