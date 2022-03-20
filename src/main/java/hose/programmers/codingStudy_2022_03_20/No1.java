package hose.programmers.codingStudy_2022_03_20;

import java.util.Scanner;
import java.util.StringTokenizer;


//백준 2455번 문제
//지능형 기차
public class No1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        int sum = 0;
        while (in.hasNextLine()) {
            String prob = in.nextLine();
            StringTokenizer st1 = new StringTokenizer(prob);
            if(prob.isEmpty()) {
                break;
            }
            int outNumber = Integer.parseInt(st1.nextToken());
            sum = sum - outNumber;
            counter = checker(sum, counter);
            int inNumber = Integer.parseInt(st1.nextToken());
            sum = sum + inNumber;
            counter = checker(sum, counter);
        }
        System.out.println("\n" + counter);
    }
    static int checker(int sum, int counter) {
        if(counter < sum) {
            return sum;
        }
        else
            return counter;
    }
}
/*
0 32
3 13
28 25
39 0
*/

