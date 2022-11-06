import java.util.*;

class Solution {
  public int solution(int[] topping) {
    int answer = 0;
    int len = topping.length;
    int countFront[] = new int[10001];
    int countRear[] = new int[10001];
    int sumFront = 0;
    int sumRear = 0;

    // cutting line
    for (int i = 0; i < len; i++) {
      int tp = topping[i];
      if (countRear[tp] == 0) {
        sumRear++;
      }
      countRear[tp]++;
    }

    for (int i = 0; i < len - 1; i++) {
      int tp = topping[i];

      // Front
      if (countFront[tp] == 0) {
        sumFront++;
      }
      countFront[tp]++;

      // Rear
      countRear[tp]--;
      if (countRear[tp] == 0) {
        sumRear--;
      }
      if (sumFront == sumRear) {
        answer++;
      }
    }

    return answer;
  }
}