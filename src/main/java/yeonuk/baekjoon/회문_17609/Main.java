package yeonuk.baekjoon.회문_17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Input input = new Input();
            input.init();

            Main main = new Main();
            main.solve(input);
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }

    public void solve(Input input) {
        for (String value : input.getValues()) {
            PalindromeType palindromeType = validatePalindromeType(value);

            System.out.println(palindromeType.getCode());
        }
    }

    private PalindromeType validatePalindromeType(String value) {
        PalindromeValidator fullValidator = new PalindromeValidator();

        for (char inputChar : value.toCharArray()) {
            fullValidator.put(inputChar);
        }

        return fullValidator.validate();
    }
}

class PalindromeValidator {

    private List<Character> inputs;

    public PalindromeValidator() {
        this.inputs = new ArrayList<>();
    }

    public void put(char inputChar) {
        inputs.add(inputChar);
    }

    public PalindromeType validate() {
//        return validate(0, inputs.size() - 1) :
return PalindromeType.FULL;
    }

    public boolean validate(int leftIndex, int rightIndex) {

        while (leftIndex < rightIndex) {
            if (inputs.get(leftIndex) != inputs.get(rightIndex)) {
                if (!validate(leftIndex + 1, rightIndex)) {
                    if (validate(leftIndex, rightIndex - 1)) {

                    }
                }
            }

            leftIndex++;
            rightIndex--;
        }

        return true;
    }
}

class Input {

    private int n;
    private List<String> values;

    public Input() {
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

enum PalindromeType {
    FULL(0),
    SIMILARITY(1),
    NONE(2),
    ;

    private final int code;

    PalindromeType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}