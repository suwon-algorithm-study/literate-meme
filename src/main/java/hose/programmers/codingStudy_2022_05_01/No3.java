package hose.programmers.codingStudy_2022_05_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No3 {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        No3 no3 = new No3();
        no3.no3_main();
    }
    void no3_main() {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        for(String show: answerReturner(record)) {
            System.out.println(show);
        }
    }
    String[] answerReturner(String[] record) {
        //각각의 유저정보를 맵으로 저장하자. 아이디값을 키값으로 하는 맵구조로
        Map<String,String> userInfo = new HashMap<>();
        String[][] stringSaver = new String[record.length][3];
        ArrayList<String> answerList = new ArrayList<>();
        //각각의 레코드값을 하나하나 확인해나가는 과정.
        for(int i = 0; i < record.length; i++){
            //하나의 스트링값을 스트링 토크나이저화시키고
            StringTokenizer token = new StringTokenizer(record[i]);
            stringSaver[i][0] = token.nextToken();
            stringSaver[i][1] = token.nextToken();

            if(stringSaver[i][0].equals("Leave")) {
                continue;
            }else {
                //유저이름을 가지고오고
                stringSaver[i][2] = token.nextToken();
                //아이디값, 유저이름
                userInfo.put(stringSaver[i][1], stringSaver[i][2]);
            }

        }
        //결과값을 리스트에 넣어주기
        for(int i = 0; i < record.length; i++){
            if(stringSaver[i][0].equals("Enter")){
                //키값을 통해 맵에 저장된 데이터를 가지고온다.
                answerList.add(userInfo.get(stringSaver[i][1]) + "님이 들어왔습니다.");
            }
            else if(stringSaver[i][0].equals("Leave")){
                answerList.add(userInfo.get(stringSaver[i][1]) + "님이 나갔습니다.");
            }
        }
        //배열에 결과저장
        String answer[] = new String[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
