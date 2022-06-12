//package seojeong.programmers.Baekjoon2846;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Solution {
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        int[] height = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i=0; i<n; i++){
//           height[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int temp = 0;
//        int result = 0;
//
//        for(int i=0; i<n-1; i++){
//            if(height[i]<height[i+1]){
//                temp += height[i+1] - height[i];
//                result = Math.max(result,temp);
//            }
//            else{
//                temp = 0;
//            }
//        }
//        System.out.println(result);
//    }
//}
