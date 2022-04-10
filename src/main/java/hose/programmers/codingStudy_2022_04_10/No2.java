package hose.programmers.codingStudy_2022_04_10;

import java.util.Scanner;
import java.util.StringTokenizer;

public class No2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());

        int[] arr = new int[N];
        int counter = 0;
        while (in.hasNextLine()) {
            String prob = in.nextLine();
            StringTokenizer st1 = new StringTokenizer(prob);
            while(st1.hasMoreTokens()) {
                arr[counter] = Integer.parseInt(st1.nextToken());
                counter++;
            }
            if(prob.isEmpty()) {
                break;
            }
        }
        for (int i = 1; i <= N; i++) {

        }
    }
}