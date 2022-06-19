package yeonuk.programmers.크레인_인형뽑기_게임;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public int solution(int[][] boards, int[] moves) {
        Board board = new Board(boards);
        Result result = new Result();

        for (int lineNumber : moves) {
            Integer doll = board.popDoll(lineNumber);
            result.push(doll);
        }

        return result.getCount();
    }

    static class Board {

        private Map<Integer, Stack<Integer>> boardMap;

        public Board(int[][] boards) {
            this.boardMap = new HashMap<>();
            for (int i = 0; i < boards.length; i++) {
                Stack<Integer> boardQueue = new Stack<>();
                boardMap.put(i + 1, boardQueue);
            }

            for (int i = boards.length - 1; i >= 0; i--) {
                int[] line = boards[i];
                for (int j = 0; j < line.length; j++) {
                    int doll = line[j];
                    if (doll != 0) {
                        Stack<Integer> boardQueue = boardMap.get(j + 1);
                        boardQueue.push(doll);
                        boardMap.put(j + 1, boardQueue);
                    }
                }
            }
        }

        public Integer popDoll(int lineNumber) {
            Stack<Integer> boardQueue = boardMap.get(lineNumber);
            if (boardQueue.isEmpty()) {
                return -1;
            } else {
                return boardQueue.pop();
            }
        }
    }

    static class Result {

        private Stack<Integer> movedQueue;

        private int count;

        public Result() {
            movedQueue = new Stack<>();
            count = 0;
        }

        public void push(int doll) {
            if (!movedQueue.isEmpty() && movedQueue.peek() == doll) {
                movedQueue.pop();
                count += 2;
            } else if (doll != -1) {
                movedQueue.push(doll);
            }
        }

        public int getCount() {
            return count;
        }
    }
}
