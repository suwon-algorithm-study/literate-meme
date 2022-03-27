package hose.programmers.codingStudy_2022_03_27;

import java.util.Scanner;
import java.util.StringTokenizer;

public class No2 {
    public static int[] arr;
    public static int answer = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        StringTokenizer st1 = new StringTokenizer(in.nextLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        checker();
        System.out.println(answer);
    }
    static void checker() {
        int[] saveArr = new int[arr.length];
        int savePointer = 0;
        //각 수를 비교하기 위한 for문을 실행
        for(int i = 0; i < arr.length - 1; i++) {
            //만약 수열의 형태를 이루고 있다면?
            if(arr[i] < arr[i + 1]) {
                //수열의 형태를 이루고있지만 처음 진행한다면?
                if(savePointer == 0) {
                    saveArr[savePointer] = arr[i];
                    saveArr[savePointer + 1] = arr[i+1];
                    savePointer+=2;
                }
                //정상적인 진행이라면?
                else {
                    saveArr[savePointer] = arr[i+1];
                    savePointer++;
                }
            }
            //수열의 형태를 이루고있지 않다면?
            else {
                //수를 비교하기위한 변수 선언
                int newAnswer = saveArr[savePointer - 1] - saveArr[0];
                //저장해둔 정답값보다 값이 크다면?
                if(answer < newAnswer) {
                    answer = newAnswer;
                }
                //최종적으로는 다시 수열의 비교를 하기위한 초기화를 진행.
                saveArr = new int[arr.length];
                savePointer = 0;
            }
        }
    }
}