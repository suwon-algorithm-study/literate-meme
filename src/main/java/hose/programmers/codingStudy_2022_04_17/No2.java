package hose.programmers.codingStudy_2022_04_17;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No2 {
    public static void main(String[] args) throws Exception {
        No2 no2 = new No2();
        no2.no2_Main();
    }
    void no2_Main() throws IOException {
        ArrayList<Integer> plusPoint = new ArrayList<Integer>(); //양수값만 저장하는 배열
        ArrayList<Integer> minusPoint = new ArrayList<Integer>();//음수값만 저장하는 배열
        //초기화
        int answer = 0, max = 0;
        Scanner in = new Scanner(System.in);
        //첫째줄
        StringTokenizer line1 = new StringTokenizer(in.nextLine());
        int bookNum = Integer.parseInt(line1.nextToken());   		// 책의 개수
        int bookCarryCount = Integer.parseInt(line1.nextToken());   // 최대로 들 수 있는 책의 개수
        //둘째줄
        StringTokenizer line2 = new StringTokenizer(in.nextLine());
        //책의 위치들을 배열에 처리하는 과정.
        while(line2.hasMoreTokens()) {
            int num = Integer.parseInt(line2.nextToken());
            //편도로 갈 max값을 지정해주는 로직.
            if (max < Math.abs(num)) {
                max = Math.abs(num);
            }

            //양수와 음수값의 분류
            if (num > 0) {
                plusPoint.add(num);
            } else {
                //어차피 양수와 음수 배열로 구분해서 진행하는 것이므로
                //절댓값으로 넣어도 상관이 없다.
                minusPoint.add(Math.abs(num));
            }

        }
        //정렬을 하되, 제일 큰값이 앞으로 오도록 정렬해준다.
        Collections.sort(plusPoint, Collections.reverseOrder());
        Collections.sort(minusPoint, Collections.reverseOrder());

        //양수의 배열값들과 음수의 배열값들이 따로따로 동작하도록.
        //양수의 배열
        for (int i = 0; i < plusPoint.size(); i++) {
            //책을 꽃는 M값에 i값이 맞아 떨어지는 경우이면서 지정한 max값과 일치한다면
            //가장 멀리 있는 곳일 경우
            //편도로 가는경우.
            if (plusPoint.get(i) == max && i % bookCarryCount == 0) {
                //단일값으로 더한다.
                answer += plusPoint.get(i);
            }
            //책을 꽃는 M값에 i값이 맞아 떨어지는 경우이면서 지정한 max값과 일치한다면
            //여기서 배열을 큰수부터 정렬하였으므로 양수내에서 제일 큰값은 무조건 한번 왕복을 하게 된다.
            //최대한 책을 많이 가지고 꽂는 위치.
            else if (i % bookCarryCount == 0) {
                //2배로 해서 더해주자.(0을 들린다는 개념이므로)
                answer += (plusPoint.get(i) * 2);
            }
        }


        //음수의 배열
        for (int i = 0; i < minusPoint.size(); i++) {
            //마찬가지 책이 가장 멀리있는 곳일 경우
            if (minusPoint.get(i) == max && i % bookCarryCount == 0) {
                answer += minusPoint.get(i);
            }
            //최대한 책을 많이 가지고 꽂는 위치
            else if (i % bookCarryCount == 0) {
                answer += (minusPoint.get(i) * 2);
            }
        }
        System.out.println(answer);
    }
}