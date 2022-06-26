package seojeong.programmers.전화번호목록;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] test = {"119", "97674223", "1195524421"};
        boolean answer = solution.solution(test);
        System.out.println(answer);
    }

    public boolean solution(String[] phone_book){
        boolean answer = true;

        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return answer;
    }
}
