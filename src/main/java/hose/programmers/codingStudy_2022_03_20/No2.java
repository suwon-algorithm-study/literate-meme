package hose.programmers.codingStudy_2022_03_20;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 2525번 문제
//오븐 시계
public class No2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringTokenizer st1 = new StringTokenizer(in.nextLine());
        int timeNumber1 = Integer.parseInt(st1.nextToken());
        int timeNumber2 = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(in.nextLine());
        int calculateTimeNum = Integer.parseInt(st2.nextToken()); //더하고싶은 값
        int timeNumber1Rst = calculateTimeNum / 60; //더하고싶은 값에서 시간값
        int timeNumber2Rst = calculateTimeNum % 60; //더하고싶은 값에서 분값
        timeNumber1 += timeNumber1Rst; //시간값을 더하고
        timeNumber2 += timeNumber2Rst; //분값을 더하고
        int timeNumber2Rst2 = timeNumber2 / 60; //더한 분값에서 다시 시간값을 도출.
        timeNumber2 = timeNumber2 % 60; //더한 분값에서 다시 분값만 도출.
        timeNumber1 += timeNumber2Rst2; //더한 분값에서 도출한 시간값을 더해줌.
        timeNumber1 = timeNumber1 % 24; //최종적으로 24시간을 넘었는지를 확인하여 24시간을 넘은 시간만 도출.
        System.out.println(timeNumber1 + " " + timeNumber2); //출력
    }
}
/*
테스트 케이스
14 30
20
23 48
25
*/
