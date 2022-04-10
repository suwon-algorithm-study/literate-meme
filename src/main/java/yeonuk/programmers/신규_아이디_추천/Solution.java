package yeonuk.programmers.신규_아이디_추천;

public class Solution {

    public String solution(String new_id) {
        String first = toLowerCase(new_id);
        String second = removeEscape(first);
        String third = removeDuplicateDot(second);
        String fourth = removeStartEndDot(third);
        String fifth = fillEmptyChar(fourth);
        String sixth = sliceOverLength(fifth);
        String seventh = fillLastChar(sixth);
        return seventh;
    }

    public String toLowerCase(String newId) {
        return newId.toLowerCase();
    }

    public String removeEscape(String newId) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < newId.length(); i++) {
            char currentChar = newId.charAt(i);

            if (currentChar >= 'a' && currentChar <= 'z') {
                builder.append(currentChar);
            } else if (currentChar >= '0' && currentChar <= '9') {
                builder.append(currentChar);
            } else if (currentChar == '-') {
                builder.append(currentChar);
            } else if (currentChar == '_') {
                builder.append(currentChar);
            } else if (currentChar == '.') {
                builder.append(currentChar);
            }
        }
        return builder.toString();
    }


    public String removeDuplicateDot(String newId) {
        StringBuilder builder = new StringBuilder();
        builder.append(newId.charAt(0));
        for (int i = 1; i < newId.length(); i++) {
            char currentChar = newId.charAt(i);
            char beforeChar = newId.charAt(i - 1);

            if (currentChar != '.' || beforeChar != '.') {
                builder.append(currentChar);
            }
        }
        return builder.toString();
    }

    private String removeStartEndDot(String newId) {
        String result = removeStartDot(newId);
        return removeEndDot(result);
    }

    private String removeStartDot(String newId) {
        return newId.startsWith(".") ? newId.substring(1) : newId;
    }

    private String removeEndDot(String newId) {
        return newId.endsWith(".") ? newId.substring(0, newId.length() - 1) : newId;
    }

    private String fillEmptyChar(String newId) {
        return newId.isEmpty() ? "a" : newId;
    }

    private String sliceOverLength(String newId) {
        String result = newId;
        if (result.length() >= 16) {
            result = newId.substring(0, 15);
        }
        if (result.endsWith(".")) {
            return removeEndDot(result);
        }
        return result;
    }

    private String fillLastChar(String newId) {
        String lastChar = newId.substring(newId.length() - 1);

        StringBuilder builder = new StringBuilder();
        builder.append(newId);
        if (newId.length() < 3) {
            builder.append(lastChar.repeat(3 - newId.length()));
        }

        return builder.toString();
    }
}
