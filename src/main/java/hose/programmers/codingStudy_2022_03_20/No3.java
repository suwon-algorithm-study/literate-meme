package hose.programmers.codingStudy_2022_03_20;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 1673번 문제
//치킨 쿠폰
public class No3 {
    public static void main(String[] args) {
        ArrayList<Integer> arr  = new ArrayList<>();
        int counter = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int sum = 0;
            String prob = in.nextLine();
            StringTokenizer st1 = new StringTokenizer(prob);
            if(prob.isEmpty()) {
                break;
            }
            int cupon = Integer.parseInt(st1.nextToken()); //치킨쿠폰값
            sum += cupon; //먼저 쿠폰값을 모두 더함.
            int sign = Integer.parseInt(st1.nextToken()); //도장값
            int No1 = cupon / sign; //쿠폰에서 도장값을 나눠서
            while(true) {
                sum += No1; //그 값을 sum값에 더한다.
                sum += No1 / sign; //sum값에 쿠폰에 도장을 나눈값을 더한다.
                No1 = No1 + No1 / sign;
                if(No1 / sign == 0)
                    break;
            }
            arr.add(sum); //최종적으로 배열에 저장.
            counter++; //배열의 길이를 늘려주자.
        }
        System.out.println();
        for(int value: arr) {
            System.out.println(value);
        }
    }
}

/*
테스트 케이스
4 3
10 3
100 5
*/
