package seojeong.programmers.Baekjoon1946;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 1; // 정렬시 첫번째 순위는 반드시 합격하니깐

            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(s[0]);
                arr[j][1] = Integer.parseInt(s[1]);
            }
            //서류 심사 기준으로 정렬
            Arrays.sort(arr,new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    return Integer.compare(o1[0],o2[0]);
                }
            });
            int pivot = arr[0][1]; //첫번째 지원자 면접 기준
            for(int j=1; j<n; j++){
                //면접 성적이 그 전 지원자보다 높을 경우 선발
                if(arr[j][1] < pivot){
                    pivot = arr[j][1];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
