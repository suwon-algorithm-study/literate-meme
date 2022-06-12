package seojeong.programmers.Baekjoon2217;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i] * (n-i));
        }
        System.out.println(max);
    }
}
