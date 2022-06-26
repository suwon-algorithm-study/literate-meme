package dain.전화번호목록;

import java.util.Arrays;

public class Solution {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;
        Arrays.sort(phoneBook);

        for (int i=0; i < phoneBook.length - 1; i++)
            if (phoneBook[i+1].startsWith(phoneBook[i]))
                return false;
        return true;
    }
}
