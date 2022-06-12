package seojeong.programmers.Baekjoon15650;

import java.util.Scanner;

public class Solution {
    static int[] arr;
    static int n,m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        combination(0,1);
    }

    public static void combination(int count, int start){
        if(count == m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<=n; i++){
            arr[count] = i;
            combination(count+1,i+1);
        }
    }
}
