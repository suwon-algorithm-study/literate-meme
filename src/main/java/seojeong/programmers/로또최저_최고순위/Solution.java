package seojeong.programmers.로또최저_최고순위;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int[] rank = {6,6,5,4,3,2,1};
        int zero = 0;
        for(int val: lottos){
            if(val == 0){
                zero += 1;
            }
        }
        int cnt = 0;
        for(int val:lottos){
            for(int j=0; j<win_nums.length; j++){
                if(val == win_nums[j]){
                    cnt += 1;
                }
            }
        }
        answer[0] = rank[cnt+zero];
        answer[1] = rank[cnt];

        return answer;
    }
}
