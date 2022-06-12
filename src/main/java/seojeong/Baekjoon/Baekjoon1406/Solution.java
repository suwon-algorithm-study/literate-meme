package seojeong.Baekjoon.Baekjoon1406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String word = br.readLine();
        int M = Integer.parseInt(br.readLine());

        //입력받은 문자열 left 스택에 넣음
        // 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있음
        for(char c:word.toCharArray()){
            left.push(c);
        }
        while(M-->0){
            String comm = br.readLine();
            char comm1 = comm.charAt(0);

            switch(comm1){
                case 'P':
                    left.push(comm.charAt(2));
                    break;
                case 'L':
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if(!left.isEmpty()){
                        left.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        while(!left.isEmpty()){
            right.push(left.pop());
        }
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
