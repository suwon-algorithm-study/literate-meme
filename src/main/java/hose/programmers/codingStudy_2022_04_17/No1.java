package hose.programmers.codingStudy_2022_04_17;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No1 {
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        No1 no1 = new No1();
        no1.no1_Main_anotherVer();
    }
    //비효율적 방법으로 코딩했던 함수
    void no1_Main() {
        Scanner in = new Scanner(System.in);
        //카드숫자들
        int checkArrNum = Integer.parseInt(in.nextLine());
        int[] checkArr = new int[checkArrNum];
        StringTokenizer checkLine = new StringTokenizer(in.nextLine());
        for(int i = 0; i < checkArrNum; i++) {
            checkArr[i] = Integer.parseInt(checkLine.nextToken());
        }
        //확인하고자 하는 숫자들
        int wantFindArrNum = Integer.parseInt(in.nextLine());
        int[] wantFindArr = new int[wantFindArrNum];
        StringTokenizer wantFindLine = new StringTokenizer(in.nextLine());
        for(int i = 0; i < wantFindArrNum; i++) {
            wantFindArr[i] = Integer.parseInt(wantFindLine.nextToken());
        }
        int[] result = check_How_Much_CheckNum(checkArr, checkArrNum, wantFindArr, wantFindArrNum);
        for(int i = 0; i < wantFindArrNum; i++) {
            System.out.print(result[i] + " ");
        }
    }
    int[] check_How_Much_CheckNum(int[] checkArr, int checkArrNum, int[] wantFindArr, int wantFindArrNum) {
        int[] result = new int[wantFindArrNum];
        //딱봐도 시간초과가 생길것 같다는 생각이 들음.
        for(int j = 0; j < wantFindArrNum; j++) {
            int numPointer = 0;
            for(int i = 0; i < checkArrNum; i++) {
                if(checkArr[i] == wantFindArr[j]) {
                    numPointer++;
                }
            }
            result[j] = numPointer;
        }
        return result;
    }

    //수정한 함수.
    void no1_Main_anotherVer() {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        //첫번째 입력부
        int N = Integer.parseInt(in.nextLine());
        StringTokenizer st = new StringTokenizer(in.nextLine());
        for(int i = 0; i < N; i++) {
            int numKey = Integer.parseInt(st.nextToken());
            //찾는 key가 존재한다면 찾는 key의 value를 반환하고 없거나 null이면 default 값을 반환한다.
            //키의값이 반환되면서 자연스럽게 키의 값에서 + 1이 되는 원리.
            map.put(numKey, map.getOrDefault(numKey, 0) + 1);
        }

        //두번째 입력부
        int M = Integer.parseInt(in.nextLine());
        st = new StringTokenizer(in.nextLine());
        for(int i = 0; i < M; i++) {
            int numKey = Integer.parseInt(st.nextToken());
            //스트링 빌더에 append시켜서 출력을 돕는다.
            sb.append(map.getOrDefault(numKey, 0) + " ");
        }
        System.out.println(sb);
    }
}