package seojeong.programmers.수식최대화;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    static char[] operations = {'+','-','*'};
    static boolean[] check = new boolean[3];
    static ArrayList<Long> numList = new ArrayList<>();
    static ArrayList<Character> operList = new ArrayList<>();
    static long answer;

    public static void main(String[] args) {

        String expression = "100-200*300-500+20";

       long result = solution(expression);
        System.out.println(result);

    }
    public static long solution(String expression){
        splitExp(expression);

        dfs(0, new char[3]);
        return answer;
    }
    public static void dfs(int count, char[] p){
        if(count == 3){
            ArrayList<Long> copyNums = new ArrayList<>(numList);
            ArrayList<Character> copyOperList = new ArrayList<>(operList);

            for(int i=0; i<p.length; i++){
                for(int j=0; j<copyOperList.size(); j++){
                    if(p[i] == copyOperList.get(j)){
                        Long temp = calc(copyNums.remove(j),copyNums.remove(j), p[i]);
                        copyNums.add(j,temp);
                        copyOperList.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(copyNums.get(0)));
            return;
        }
        for(int i= 0; i<3; i++){
            if(!check[i]){
                check[i] = true;
                p[count] = operations[i];
                dfs(count+1, p);
                check[i] = false;
            }
        }
    }

    // 수식 분리: 숫자 -> numList 연산자 -> operList
    static void splitExp(String expression){
        String temp = "";
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);

            if(c == '-' || c == '+' || c =='*' ){
                operList.add(c);
                numList.add(Long.parseLong(temp));
                temp = "";
            }else{
                temp += c;
            }
        }
        numList.add(Long.parseLong(temp));
    }

    // 연산자에 따른 계산
    static long calc(long num1, long num2, char op){
        long num = 0;
        switch(op){
            case '+':
                num = num1 + num2;
                break;
            case '-':
                num = num1 - num2;
                break;
            case '*':
                num = num1 * num2;
                break;
        }
        return num;
    }

}
