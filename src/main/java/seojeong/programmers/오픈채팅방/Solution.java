package seojeong.programmers.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args){

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        List<String> log = new ArrayList<>();
        Map<String,String> users = new HashMap<>();

        for(int i=0; i<record.length; i++){
            String[] command = record[i].split(" ");

            if(command[0].equals("Enter")){
                users.put(command[1],command[2]);
                log.add(command[1]+"님이 들어왔습니다.");
            }
            else if(command[0].equals("Change")){
                users.put(command[1],command[2]);
            }
            else{
                log.add(command[1]+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[log.size()];

        for(int i=0; i<log.size(); i++){
            String result = log.get(i);
            int idx = log.get(i).indexOf("님");

            String userId = log.get(i).substring(0,idx);
            String nickname = users.get(userId);

            result = result.replace(userId,nickname);
            answer[i] = result;
        }
        for(String val:answer){
            System.out.println(val);
        }

    }
}
