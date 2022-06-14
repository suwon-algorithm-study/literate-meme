package yeonuk.baekjoon.회문_17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        try {
            Input2 input = new Input2();
            input.init();

            Main2 main = new Main2();
            main.solve(input);
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }

    public void solve(Input2 input) {
        for (String value : input.getValues()) {
            PalindromeType2 palindromeType = validatePalindromeType(value);

            System.out.println(palindromeType.getCode());
        }
    }

    private PalindromeType2 validatePalindromeType(String value) {
        PalindromeValidator2 validator = new PalindromeValidator2();

        for (char inputChar : value.toCharArray()) {
            validator.put(inputChar);
        }

        return validator.getPalindromeType();
    }
}

class PalindromeValidator2 {

    private Stack<Character> inputs;

    private Stack<Character> secondInputs;
    private Map<Character, Integer> inputCounts;

    public PalindromeValidator2() {
        this.inputs = new Stack<>();
        this.secondInputs = new Stack<>();
        this.inputCounts = new HashMap<>();
    }

    public void put(char inputChar) {
        if (!inputs.isEmpty() && inputs.peek() == inputChar) {
            inputs.pop();

            Integer count = inputCounts.get(inputChar);
            count -= 1;
            inputCounts.put(inputChar, count);
        } else {
            inputs.push(inputChar);

            Integer count = inputCounts.getOrDefault(inputChar, 0);
            count += 1;
            inputCounts.put(inputChar, count);
        }
    }

    public PalindromeType2 getPalindromeType() {
        if (inputs.isEmpty()) {
            return PalindromeType2.FULL;
        }

        Optional<Character> singleKey = inputCounts.entrySet()
                .stream()
                .filter(v -> v.getValue() == 1)
                .findAny()
                .map(Map.Entry::getKey);

        if (singleKey.isEmpty()) {
            return PalindromeType2.NONE;
        }
        Character key = singleKey.get();

        int index = 0;
        int keyIndex = -1;
        for (Character input : inputs) {
            if (input == key) {
                keyIndex = inputs.size() - index;
                continue;
            }
            index += 1;

            if (!secondInputs.isEmpty() && secondInputs.peek() == input) {
                secondInputs.pop();
            } else {
                secondInputs.push(input);
            }
        }

        if (secondInputs.isEmpty()) {
            if (inputs.size() / 2 == keyIndex) {
                return PalindromeType2.FULL;
            } else {
                return PalindromeType2.SIMILARITY;
            }
        }  else {
            return PalindromeType2.NONE;
        }
    }

    private boolean isFull() {
        return this.inputs.isEmpty();
    }

    private boolean isSimilarity() {

        Optional<Character> inputKey = inputCounts.entrySet()
                .stream()
                .filter(v -> v.getValue() == 1)
                .findAny()
                .map(Map.Entry::getKey);

        if (inputKey.isEmpty()) {
            return false;
        }
        Character key = inputKey.get();

        Stack<Character> newInputs = new Stack<>();

        for (Character input : inputs) {
            if (input == key) {
                continue;
            }

            if (!newInputs.isEmpty() && newInputs.peek() == input) {
                newInputs.pop();
            } else {
                newInputs.push(input);
            }
        }

        return newInputs.isEmpty();
    }
}

class Input2 {

    private int n;
    private List<String> values;

    public Input2() {
        this.values = new ArrayList<>();
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            values.add(stk.nextToken());
        }

        br.close();
    }

    public int getN() {
        return n;
    }

    public List<String> getValues() {
        return values;
    }
}

enum PalindromeType2 {
    FULL(0),
    SIMILARITY(1),
    NONE(2),
    ;

    private final int code;

    PalindromeType2(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}