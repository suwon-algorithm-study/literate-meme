package seojeong.programmers.Baekjoon14886;

import java.util.Scanner;

public class Solution {
    static int MAX_VALUE = Integer.MIN_VALUE;
    static int MIN_VALUE = Integer.MAX_VALUE;
    static int[] operator = new int[4];
    static int[] number;
    static int n;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        number = new int[n];

        for(int i=0; i<n; i++){
            number[i] = sc.nextInt();
        }
        for(int i=0; i<4; i++){
            operator[i] = sc.nextInt();
        }

        cal(number[0],1);
        System.out.println(MAX_VALUE);
        System.out.println(MIN_VALUE);
    }

    public static void cal(int num, int idx){
        if(idx == n){
            MAX_VALUE = Math.max(MAX_VALUE,num);
            MIN_VALUE = Math.min(MIN_VALUE,num);
            return;
        }

        for(int i=0; i<4; i++){

            if(operator[i] >0){
                operator[i]--;

                switch(i){
                    case 0:
                        cal(num+ number[idx], idx + 1);
                        break;

                    case 1:
                        cal(num-number[idx], idx+1);
                        break;
                    case 2:
                        cal(num*number[idx],idx+1);
                        break;
                    case 3:
                        cal(num/number[idx],idx+1);
                        break;
                }
                operator[i]++;

            }

        }
    }
}
