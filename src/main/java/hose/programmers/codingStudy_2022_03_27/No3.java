package hose.programmers.codingStudy_2022_03_27;

import java.util.Scanner;
import java.util.StringTokenizer;

public class No3 {
    public static int[][] arr;
    public static int answer = 1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(in.nextLine());
            arr[i][0] = Integer.parseInt(st1.nextToken());
            arr[i][1] = Integer.parseInt(st1.nextToken());
        }
        for(int i = 1; i < N; i++) {
            newChecker(i, arr[0][1], 1);
        }
        System.out.println(answer);
    }
    //시작지점, 비교값, 안겹치는 회의실값
    static void newChecker(int start, int compare, int counter) {
        if(start == arr.length - 1) {
            if(answer < counter)
                answer = counter;
        }
        for(int i = start; i < arr.length - 1; i++) {
            if(compare < arr[i][0]) {
                if(arr[i][0] != arr[i][1])
                    newChecker(start + 1, arr[i][1], counter + 1);
                else
                    newChecker(start + 1, arr[i][1], counter);
            }
            else
                newChecker(start + 1, arr[i][1], counter);
        }
    }
	/*
	static void checker() {
		int[] saveArr = arr[0];
		int newAnswer = 1;
		for(int i = 1; i < arr.length - 1; i++) {
			if(saveArr[1] < arr[i][0]) {
				newAnswer++;
				saveArr = arr[i];
			}
			else {
				if(newAnswer > answer) {
					answer = newAnswer;
				}
				saveArr = arr[i + 1];
				newAnswer = 1;
			}
		}
	}
	*/
}

