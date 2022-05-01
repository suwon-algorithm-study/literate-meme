package seojeong.programmers.나라숫자124;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String answer = "";
        StringBuilder sb =new StringBuilder();

        String[] arr = {"4","1","2"};

        while(n>0) {
            sb.append(arr[n % 3]);
            if (n % 3 == 0) {
                n -= 1;
            }
            n/=3;
        }
        System.out.println(sb.reverse().toString());

    }
}
