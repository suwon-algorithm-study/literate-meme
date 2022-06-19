package seojeong.programmers.기능개발;
import java.util.*;


public class Solution {
    public static void main(String[] args){
        int[] answer = {};
        int[] progresses = {93, 30, 55};
        int[] speeds = {1,30,5};


        int[] res = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            res[i] = (100 - progresses[i])/speeds[i];
            //나머지 처리
            if((100 - progresses[i])%speeds[i] != 0){
                res[i] += 1;
            }
        }

//         for(int val:res){
//             System.out.print(val+" ");
//         }
        List<Integer> list = new ArrayList<>();
        int first = res[0];
        int count = 1;
        for(int i=1; i<res.length; i++){
            if(res[i]<=first){
                count++;
                continue;
            }else{
                list.add(count);
                count = 1;
                first = res[i];
            }
            if(i == res.length-1 ){
                list.add(count);
            }
        }

        if(count != 1){
            list.add(count);
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
            answer[i] = list.get(i);
        }
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i] +" ");
        }
    }
}
