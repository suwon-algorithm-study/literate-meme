package yeonuk.baekjoon.팰린드롬_만들기_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public String solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        String answer = stk.nextToken();

        List<Character> answerCharacter = new ArrayList<>();
        for (int i = 0; i < answer.length(); i++) {
            char character = answer.charAt(i);
            answerCharacter.add(character);
        }
        Collections.sort(answerCharacter);

        StringBuilder startBuilder = new StringBuilder();
        StringBuilder endBuilder = new StringBuilder();

        Set<Character> uniqueCharacters = new HashSet<>(answerCharacter);

        int limitCount = 2;
        Character middleChar = null;
        for (Character uniqueChar : uniqueCharacters) {
            long count = answerCharacter.stream()
                    .filter(c -> c == uniqueChar)
                    .count();

            if (count % 2 == 0) {
                for (int i = 0; i < count / 2; i++) {
                    startBuilder.append(uniqueChar);
                    endBuilder.append(uniqueChar);
                }
            } else {
                limitCount--;
                if (limitCount == 0) {
                    return "I'm Sorry Hansoo";
                }
                middleChar = uniqueChar;
            }
        }

        String start = startBuilder.toString();
        endBuilder.reverse();
        String end = endBuilder.toString();

        return middleChar == null ? start + end
                : start + middleChar + end;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        String result = main.solve();

        System.out.println(result);
    }
}
