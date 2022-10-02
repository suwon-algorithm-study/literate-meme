package yeonuk.programmers.성격_유형_검사하기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solution {

    public String solution(String[] survey, int[] choices) {
        User user = new User();

        for (int i = 0; i < survey.length; i++) {
            IndicatorType indicatorType = IndicatorType.findBySymbol(survey[i]);
            ChoiceType choiceType = ChoiceType.findByValue(choices[i]);
            user.choice(indicatorType, choiceType);
        }

        return user.getResult();
    }
}

class User {

    private final Map<PersonalityType, Integer> scoreBoard;

    public User() {
        scoreBoard = new HashMap<>();
        scoreBoard.put(PersonalityType.RYON, 0);
        scoreBoard.put(PersonalityType.TUBE, 0);
        scoreBoard.put(PersonalityType.CON, 0);
        scoreBoard.put(PersonalityType.FRODO, 0);
        scoreBoard.put(PersonalityType.JAY_G, 0);
        scoreBoard.put(PersonalityType.MUZI, 0);
        scoreBoard.put(PersonalityType.APEACH, 0);
        scoreBoard.put(PersonalityType.NEO, 0);
    }

    public void choice(IndicatorType indicatorType, ChoiceType choiceType) {
        ScoreDto scoreDto = ScoreCalculator.calculate(indicatorType, choiceType);
        int score = scoreBoard.get(scoreDto.getPersonalityType());
        score += scoreDto.getScore();
        scoreBoard.put(scoreDto.getPersonalityType(), score);
    }

    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();

        for (IndicatorType indicatorType : IndicatorType.getDistinctIndicateTypes()) {
            String symbol = getSymbol(indicatorType);
            stringBuilder.append(symbol);
        }

        return stringBuilder.toString();
    }

    private String getSymbol(IndicatorType indicatorType) {
        PersonalityType leftPersonalityType = indicatorType.getLeft();
        PersonalityType rightPersonalityType = indicatorType.getRight();

        int leftScore = scoreBoard.get(leftPersonalityType);
        int rightScore = scoreBoard.get(rightPersonalityType);

        if (leftScore > rightScore) {
            return leftPersonalityType.getSymbol();
        } else if (leftScore < rightScore) {
            return rightPersonalityType.getSymbol();
        } else {
            String leftSymbol = leftPersonalityType.getSymbol();
            String rightSymbol = rightPersonalityType.getSymbol();
            if (leftSymbol.compareTo(rightSymbol) < 0) {
                return leftSymbol;
            } else {
                return rightSymbol;
            }
        }
    }
}

abstract class ScoreCalculator {

    public static ScoreDto calculate(IndicatorType indicatorType, ChoiceType choiceType) {
        switch (choiceType) {
            case VERY_DISAGREE:
            case DISAGREE:
            case LITTLE_DISAGREE:
            case MIDDLE:
                return new ScoreDto(indicatorType.getLeft(), choiceType.getScore());
            case LITTLE_AGREE:
            case AGREE:
            case VERY_AGREE:
                return new ScoreDto(indicatorType.getRight(), choiceType.getScore());
            default:
                throw new IllegalStateException();
        }
    }

    private ScoreCalculator() {
    }
}

class ScoreDto {

    private final PersonalityType personalityType;
    private final int score;

    public ScoreDto(PersonalityType personalityType, int score) {
        this.personalityType = personalityType;
        this.score = score;
    }

    public PersonalityType getPersonalityType() {
        return personalityType;
    }

    public int getScore() {
        return score;
    }
}

enum PersonalityType {
    RYON("R", "라이언형"),
    TUBE("T", "튜브형"),
    CON("C", "콘형"),
    FRODO("F", "프로도형"),
    JAY_G("J", "제이지형"),
    MUZI("M", "무지형"),
    APEACH("A", "어피치형"),
    NEO("N", "네오형"),
    ;

    private final String symbol;
    private final String text;

    PersonalityType(String symbol, String text) {
        this.symbol = symbol;
        this.text = text;
    }

    public String getSymbol() {
        return symbol;
    }
}

enum IndicatorType {

    RT(1, "RT", PersonalityType.RYON, PersonalityType.TUBE),
    TR(1, "TR", PersonalityType.TUBE, PersonalityType.RYON),
    CF(2, "CF", PersonalityType.CON, PersonalityType.FRODO),
    FC(2, "FC", PersonalityType.FRODO, PersonalityType.CON),
    JM(3, "JM", PersonalityType.JAY_G, PersonalityType.MUZI),
    MJ(3, "MJ", PersonalityType.MUZI, PersonalityType.JAY_G),
    AN(4, "AN", PersonalityType.APEACH, PersonalityType.NEO),
    NA(4, "NA", PersonalityType.NEO, PersonalityType.APEACH),
    ;

    private final int value;
    private final String symbol;
    private final PersonalityType left;
    private final PersonalityType right;

    IndicatorType(int value, String symbol, PersonalityType left, PersonalityType right) {
        this.value = value;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    public static IndicatorType findBySymbol(String symbol) {
        return Arrays.stream(IndicatorType.values())
                .filter(it -> it.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 타입입니다. symbol=" + symbol));
    }

    public static List<IndicatorType> getDistinctIndicateTypes() {
        return Arrays.stream(values())
                .filter(SolutionUtils.distinctByKey(it -> it.value))
                .collect(Collectors.toList());
    }

    public int getValue() {
        return value;
    }

    public PersonalityType getLeft() {
        return left;
    }

    public PersonalityType getRight() {
        return right;
    }
}

abstract class SolutionUtils {

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private SolutionUtils() {
    }
}

enum ChoiceType {
    VERY_DISAGREE(1, "매우 비동의", 3),
    DISAGREE(2, "비동의", 2),
    LITTLE_DISAGREE(3, "약간 비동의", 1),
    MIDDLE(4, "모르겠음", 0),
    LITTLE_AGREE(5, "약간 동의", 1),
    AGREE(6, "동의", 2),
    VERY_AGREE(7, "매우 동의", 3),
    ;

    private final int value;
    private final String text;
    private final int score;

    ChoiceType(int value, String text, int score) {
        this.value = value;
        this.text = text;
        this.score = score;
    }

    public static ChoiceType findByValue(int value) {
        return Arrays.stream(ChoiceType.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 타입입니다. value=" + value));
    }

    public int getScore() {
        return score;
    }
}