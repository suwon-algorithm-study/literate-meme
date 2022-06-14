package seojeong.programmers.Baekjoon15649;
import java.util.Scanner;

public class Solution {

    static int[] arr;
    static boolean[] check;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[m];
        check = new boolean[n];

        permutation(0,n,m);
    }
    public static void permutation(int count, int n, int m){
        if(count == m){
            for(int val:arr){
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(check[i]){
                continue;
            }
            check[i] = true;
            arr[count] = i+1;
            permutation(count+1,n,m);
            check[i] = false;
        }
    }
}
