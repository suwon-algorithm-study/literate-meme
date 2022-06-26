package yeonuk.programmers.전화번호목록;

import java.util.Arrays;
        import java.util.Collections;
        import java.util.List;

public class Solution {
    public boolean solution(String[] phone_book) {
        List<String> phoneBook = Arrays.asList(phone_book);
        Collections.sort(phoneBook);

        for (int i = 0; i < phoneBook.size() - 1; i++) {
            String current = phoneBook.get(i);
            String next = phoneBook.get(i + 1);
            if (next.startsWith(current)) {
                return false;
            }
        }

        return true;
    }
}


//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//public class Solution {
//    public boolean solution(String[] phone_book) {
//        List<String> phoneBook = Arrays.asList(phone_book);
//        phoneBook.sort(Comparator.comparing(String::length));
//
//        for (String phoneNo : phoneBook) {
//            if (phoneBook.stream()
//                    .filter(p -> !p.equals(phoneNo))
//                    .anyMatch(p -> p.startsWith(phoneNo))) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}