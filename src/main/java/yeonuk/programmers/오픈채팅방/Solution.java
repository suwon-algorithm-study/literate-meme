package yeonuk.programmers.오픈채팅방;

import java.util.*;

public class Solution {

    private Map<String, String> nickNames = new HashMap<>();

    public String[] solution(String[] input) {

        initNickName(input);

        return toResult(input);
    }

    private void initNickName(String[] input) {
        for (String record : input) {
            String[] recordArray = record.split(" ");
            String command = recordArray[0];
            String id = recordArray[1];

            if ("Enter".equals(command) || ("Change".equals(command) && nickNames.containsKey(id))) {
                String nickName = recordArray[2];
                nickNames.put(id, nickName);
            }
        }
    }

    private String[] toResult(String[] input) {
        List<String> results = new ArrayList<>();
        for (String record : input) {
            String[] recordArray = record.split(" ");
            String command = recordArray[0];
            String id = recordArray[1];
            String nickName = nickNames.get(id);

            if ("Enter".equals(command)) {
                results.add(String.format("%s님이 들어왔습니다.", nickName));
            } else if ("Leave".equals(command)) {
                results.add(String.format("%s님이 나갔습니다.", nickName));
            }
        }

        return results.toArray(String[]::new);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = solution.solution(record);

        System.out.println(Arrays.toString(result));
    }
}
