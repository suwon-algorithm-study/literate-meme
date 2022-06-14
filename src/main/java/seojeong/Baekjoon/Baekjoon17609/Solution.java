package seojeong.Baekjoon.Baekjoon17609;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String s = br.readLine();
            int result = checkPalin(s);

            if(result >= 2){
                System.out.println(result - 1);
            }else{
                System.out.println(result);
            }


        }
    }
    private static int checkPalin(String s){
        int result = 0; //다른 개수
        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }else{ //왼쪽, 오른쪽 문자가 같지 않은 경우 -> 다른 지점 발생
                result += 1;
                //왼쪽 증가해서 체크
                int newL = left + 1;
                int newR = right;

                while(newL <= newR){
                    //왼쪽에서 하나를 증가시켰을 때 문자가 같으면, 진행해서 팰린드롬인지 확인
                    if(s.charAt(newL) == s.charAt(newR)){
                        newL++;
                        newR--;
                    }else{
                        result++;
                        break;
                    }
                }
                //오른쪽 감소해서 체크
                newL = left;
                newR = right - 1;
                while(newL <= newR){
                    //위와 동일하게 진행
                    if(s.charAt(newL) == s.charAt(newR)){
                        newL++;
                        newR--;
                    }else{
                        result++;
                        break;
                    }
                }
                return result;
            }

        }
        return result;
    }
}
