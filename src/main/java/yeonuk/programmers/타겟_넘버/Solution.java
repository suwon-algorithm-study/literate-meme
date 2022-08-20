package yeonuk.programmers.타겟_넘버;

public class Solution {

    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }

    private int dfs(int current, int index, int[] numbers, int target) {
        if (index >= numbers.length) {
            return current == target ? 1 : 0;
        }

        return dfs(current + numbers[index], index + 1, numbers, target)
                + dfs(current - numbers[index], index + 1, numbers, target);
    }
}

/**
 * 1    1   1   3==3?    3
 *         -1      1
 *      -1  1       1
 *        -1      -1
 * -1   1   1       1
 *         -1      1
 *      -1  1       -1
 *        -1      -3
 *
 *
 */
