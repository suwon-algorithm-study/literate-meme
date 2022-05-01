package seojeong.programmers.짝지어제거하기;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Stack<Character> stack =new Stack<>();
        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() ==c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        System.out.println(stack.isEmpty()?1:0);

    }
}
