package yeonuk.programmers.숫자_문자열과_영단어;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<String, String> numbers = new HashMap<>();

    public Solution() {
        this.numbers.put("zero", "0");
        this.numbers.put("one", "1");
        this.numbers.put("two", "2");
        this.numbers.put("three", "3");
        this.numbers.put("four", "4");
        this.numbers.put("five", "5");
        this.numbers.put("six", "6");
        this.numbers.put("seven", "7");
        this.numbers.put("eight", "8");
        this.numbers.put("nine", "9");
    }

    public String solve(String s) {
        String result = s;

        for (Map.Entry<String, String> entry : numbers.entrySet()) {
            result = result.replaceAll(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
