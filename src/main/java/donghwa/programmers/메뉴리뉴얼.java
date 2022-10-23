import java.util.HashSet;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

class Solution {
  static int maxLen = 2; // 지정한 코스 최대 주문인원
  static HashSet<String> not_in_result;
  static HashSet<String> result;

  public String[] solution(String[] orders, int[] course) {
    String[] answer = {};
    result = new HashSet<String>();
    for (int i = 0; i < orders.length; i++) {
      char[] chars = orders[i].toCharArray();
      Arrays.sort(chars);
      orders[i] = new String(chars);
    }
    for (int i = 0; i < course.length; i++) { // 지정한 코스 개수만큼 돌기
      HashSet<String> set = new HashSet<String>();
      for (int j = 0; j < orders.length - 1; j++) {
        boolean[] containCheck = new boolean[orders.length];
        Arrays.fill(containCheck, true);
        findResult(course[i], course[i], "", set, j, orders, 0, containCheck, containCheck.length);
      }
      maxLen = 2;
      Iterator<String> it = set.iterator();
      while (it.hasNext()) {
        result.add(it.next());
      }
    }
    String[] ans = result.toArray(new String[0]);
    Arrays.sort(ans);

    return ans;
  }

  void findResult(int course, int depth, String _result, HashSet<String> set, int nowOrder, String[] orders, int idx,
      boolean[] containCheck, int containLen) {
    if (orders[nowOrder].length() < course) {
      return;
    }
    if (containLen < maxLen)
      return;
    if (depth == 0) {
      if (containLen > maxLen) {
        maxLen = containLen;
        set.clear();
        set.add(_result);
      } else {
        set.add(_result);
      }
    } else {
      for (int k = idx; k <= orders[nowOrder].length() - depth; k++) {
        char menu = orders[nowOrder].charAt(k);
        String _r = _result + menu;
        boolean[] check = new boolean[containCheck.length];
        int len = 0;
        for (int l = 0; l < containCheck.length; l++) {
          if (containCheck[l]) {
            for (int m = 0; m < orders[l].length(); m++) {
              if (orders[l].charAt(m) == menu) {
                check[l] = true;
                len++;
              }
            }
          }
        }
        findResult(course, depth - 1, _r, set, nowOrder, orders, k + 1, check, len);
      }
    }
  }
}