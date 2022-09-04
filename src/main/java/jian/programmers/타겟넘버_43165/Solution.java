package jian.programmers.타겟넘버_43165;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(sol.solution(numbers, target));
    }

    int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return this.count;
    }

    public void dfs(int[] numbers, int target, int depth, int total) {
        if (depth == numbers.length) {
            if (total == target) {
                this.count++;
            }

            return;
        }

        dfs(numbers, target, depth + 1, total + numbers[depth]);
        dfs(numbers, target, depth + 1, total - numbers[depth]);
    }
}
