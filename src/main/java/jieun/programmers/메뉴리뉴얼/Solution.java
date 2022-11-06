package jieun.programmers.메뉴리뉴얼;
import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public String[] solution(String[] orders, int[] course) {
        List<String>  answers = new ArrayList();
        String sAnswer = "";
        for(int cs : course) {
            for(String order : orders) {
                String[] menus = order.split("");
                Arrays.sort(menus);

                int n = menus.length;
                int r = cs;
                boolean[] visited = new boolean[n];
                comb(menus, visited, 0, n, r);
            }
            map = sortMapByValue(map);

            int idx = 0;
            int max = 0;

            for (String key : map.keySet()) {
                if(idx == 0) {
                    if(map.get(key) > 0) {
                        answers.add(key);
                        max = map.get(key);
                    } else {
                        break;
                    }
                } else {
                    if(map.get(key) < max) { break;}
                    if(map.get(key) == max) {
                        answers.add(key);
                    }
                }
                idx++;
            }

            map.clear();
        }
        Collections.sort(answers);
        String[] answer = answers.toArray(String[]::new);
        return answer;
    }

    public void comb(String[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            setCombInMap(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 배열 출력
    public void setCombInMap(String[] arr, boolean[] visited, int n) {
        String temp = "";
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                temp += arr[i];
            }
        }
        if(map.containsKey(temp)) {
            map.put(temp, map.get(temp)+1);
        } else {
            map.put(temp,0);
        }
    }

    public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}


