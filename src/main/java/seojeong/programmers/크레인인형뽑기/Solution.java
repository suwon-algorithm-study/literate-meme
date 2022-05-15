package seojeong.programmers.크레인인형뽑기;

import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        //System.out.println(n);
        for(int i=0; i<moves.length; i++){
            int curr = moves[i];
            for(int j=0; j<board.length; j++){
                if(board[j][curr-1] != 0){
                    if(stack.isEmpty()){
                        stack.push(board[j][curr-1]);
                    }
                    else{
                        if(board[j][curr-1] == stack.peek()){
                            stack.pop();
                            answer += 2;
                        }
                        else{
                            stack.push(board[j][curr-1]);
                        }
                    }
                    board[j][curr-1] = 0;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
