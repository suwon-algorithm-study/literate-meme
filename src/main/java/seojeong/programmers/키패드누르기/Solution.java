package seojeong.programmers.키패드누르기;

public class Solution {
    public static void main(String[] args){
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // 1,4,7인 경우 왼손
        //3,6,9인 경우 오른손
        //2,5,8의 경우 왼손, 오른손 중 가까운 위치에 있는거로 -> 같을 경우 어느손잡이냐에 따라

        int left = 10;
        int right = 12;

        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                left = numbers[i];

            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                right = numbers[i];
            }
            else{
                if(numbers[i] == 0){
                    numbers[i] = 11;
                }
                int leftDist = Math.abs(numbers[i] - left)/3 + Math.abs(numbers[i] - left)%3;
                int rightDist = Math.abs(numbers[i] - right)/3 + Math.abs(numbers[i] - right)%3;
                if(leftDist < rightDist){
                    sb.append("L");
                    left = numbers[i];
                }
                else if(rightDist < leftDist){
                    sb.append("R");
                    right = numbers[i];
                }
                else{
                    if(hand.equals("left")){
                        sb.append("L");
                        left = numbers[i];
                    }else{
                        sb.append("R");
                        right = numbers[i];
                    }
                }
            }
        }
        answer = sb.toString();
        System.out.println(answer);
    }
}
