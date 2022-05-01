package yeonuk.programmers._124_나라의_숫자;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.solution(513);
        System.out.println(answer);
    }

    public String solution(int n) {
        String result = toTernary(n);
        while (result.contains("0") && !result.startsWith("0")) {
            result = convertZeroToThree(result);
        }
        String answer = result.replaceAll("3", "4");

        if (answer.startsWith("0")) {
            return answer.substring(1);
        }

        return answer;
    }

    private String toTernary(int n) {
        StringBuilder builder = new StringBuilder();
        int quotient = n;
        while (quotient >= 3) {
            int remainder = quotient % 3;
            builder.append(remainder);

            quotient /= 3;
        }
        builder.append(quotient);

        builder.reverse();

        return builder.toString();
    }

    private String convertZeroToThree(String number) {
        char[] resultArray = number.toCharArray();
        for (int i = 1; i < number.length(); i++) {
            if (resultArray[i] == '0') {
                int beforeNumber = (int) resultArray[i - 1] - 1;
                resultArray[i - 1] = (char) beforeNumber;

                int currentNumber = (int) resultArray[i] + 3;
                resultArray[i] = (char) currentNumber;
            }
        }

        return String.valueOf(resultArray);
    }
}

/**
 * 10
 * 3 1
 * 1 0
 * 0 1
 * <p>
 * 13
 * 4 1
 * 1 1
 * <p>
 * 15
 * 5 0
 * 1 2
 * <p>
 * 20
 * 6 2
 * 2 0
 * <p>
 * <p>
 * 1 / 0 1 / 1 / 1
 * 2 / 0 2 / 2 / 2
 * 3 / 1 0 / 4 / 3
 * 4 / 1 1 / 11 / 11
 * 5 / 1 2 / 12 / 12
 * 6 / 2 0 / 14 / 13
 * 7 / 2 1 / 2 1 / 21
 * <p>
 * 10 / 31
 * <p>
 * 12 / 33
 * 13/ / 111
 * 15 / 113
 * 1 0  1
 * 2 1  2
 * 3 2  3
 * 4 10 11
 * 5 11 12
 * 6 12 13
 * 7 20 21
 * 8 21 22
 * 9 22 23
 * 10 30    31
 */

/**
 * 1 / 0 1 / 1 / 1
 * 2 / 0 2 / 2 / 2
 * 3 / 1 0 / 4 / 3
 * 4 / 1 1 / 11 / 11
 * 5 / 1 2 / 12 / 12
 * 6 / 2 0 / 14 / 13
 * 7 / 2 1 / 2 1 / 21
 *
 * 10 / 31
 *
 * 12 / 33
 * 13/ / 111
 * 15 / 113
 * 1 0  1
 * 2 1  2
 * 3 2  3
 * 4 10 11
 * 5 11 12
 * 6 12 13
 * 7 20 21
 * 8 21 22
 * 9 22 23
 * 10 30    31
 */
