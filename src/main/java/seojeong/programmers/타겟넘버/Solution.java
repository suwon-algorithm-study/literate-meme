package seojeong.programmers.타겟넘버;

public class Solution {
    public static int answer = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solution(new int[]{1,1,1,1,1}, 3);
        System.out.println(answer);

    }
    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0,0);
        return answer;
    }
    // 모든 경우를 다 탐색 -> 완전 탐색
    // 탐색한 최종 값이(sum) == target 과 같으면 카운트 증가
    public void dfs(int[] numbers, int target, int idx, int sum){
        // 마지막 숫자까지 탐색 되었는지
        if(idx == numbers.length){
            if(sum == target){
                answer++;
            }
        }else{// 아니면 dfs 진행
            dfs(numbers,target, idx+1, sum - numbers[idx]);
            dfs(numbers, target, idx+1, sum + numbers[idx]);
        }
    }
}
