package yeonuk.programmers.키패드_누르기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public String solution(int[] numbers, String hand) {
        KeyPad keyPad = new KeyPad();
        Hand leftHand = new Hand();
        Hand rightHand = new Hand();
        HandType handType = HandType.findByText(hand);


        List<HandType> answer = new ArrayList<>();
        for (int number : numbers) {
            Key key = keyPad.findKey(number);

            if (key.isLeftKey()) {
                leftHand.move(key.getX(), key.getY());
                answer.add(HandType.LEFT);

            } else if (key.isRightKey()) {
                rightHand.move(key.getX(), key.getY());
                answer.add(HandType.RIGHT);

            } else if (key.isMiddleKey()) {
                double leftDistance = leftHand.getDistance(key.getX(), key.getY());
                double rightDistance = rightHand.getDistance(key.getX(), key.getY());

                if (leftDistance < rightDistance) {
                    leftHand.move(key.getX(), key.getY());
                    answer.add(HandType.LEFT);

                } else if (leftDistance > rightDistance) {
                    rightHand.move(key.getX(), key.getY());
                    answer.add(HandType.RIGHT);

                } else {
                    if (handType == HandType.LEFT) {
                        leftHand.move(key.getX(), key.getY());
                        answer.add(HandType.LEFT);

                    } else if (handType == HandType.RIGHT) {
                        rightHand.move(key.getX(), key.getY());
                        answer.add(HandType.RIGHT);
                    }
                }
            } else {
                throw new IllegalArgumentException("유효하지 않은 입력");
            }
        }

        return answer.stream()
                .map(HandType::getKeyword)
                .collect(Collectors.joining());
    }
}

class Hand {

    private int x;
    private int y;

    public Hand() {
        this.x = 0;
        this.y = 0;
    }

    public void move(int nextX, int nextY) {
        this.x = nextX;
        this.y = nextY;
    }

    public double getDistance(int nextX, int nextY) {
        return Math.abs(this.x - nextX) + Math.abs(this.y - nextY);
    }
}

class KeyPad {

    private final List<Key> keys;

    public KeyPad() {
        this.keys = new ArrayList<>();

        keys.add(new Key(0, 3, 1));
        keys.add(new Key(1, 3, 2));
        keys.add(new Key(2, 3, 3));

        keys.add(new Key(0, 2, 4));
        keys.add(new Key(1, 2, 5));
        keys.add(new Key(2, 2, 6));

        keys.add(new Key(0, 1, 7));
        keys.add(new Key(1, 1, 8));
        keys.add(new Key(2, 1, 9));

        keys.add(new Key(1, 0, 0));
    }

    public Key findKey(int value) {
        return keys.stream()
                .filter(key -> key.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 키"));
    }
}

class Key {

    private final int x;
    private final int y;

    private final int value;

    private final HandType handType;

    public Key(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.handType = HandType.findByValue(value);
    }

    public boolean equals(int value) {
        return value == this.value;
    }

    public boolean isLeftKey() {
        return handType == HandType.LEFT;
    }

    public boolean isRightKey() {
        return handType == HandType.RIGHT;
    }

    public boolean isMiddleKey() {
        return handType == HandType.Middle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

enum HandType {

    LEFT("left", "L", Arrays.asList(1, 4, 7)),
    RIGHT("right", "R", Arrays.asList(3, 6, 9)),
    Middle("middle", "M", Arrays.asList(2, 5, 8, 0)),
    NONE("none", "N", Collections.emptyList()),
    ;

    private final String text;

    private final String keyword;

    private final List<Integer> values;

    HandType(String text, String keyword, List<Integer> values) {
        this.text = text;
        this.keyword = keyword;
        this.values = values;
    }

    public static HandType findByText(String text) {
        return Arrays.stream(values())
                .filter(handType -> handType.text.equals(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("왼손잡이, 오른손잡이만 가능합니다."));
    }

    public static HandType findByValue(int value) {
        return Arrays.stream(values())
                .filter(handType -> handType.values.contains(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 키"));
    }

    public String getKeyword() {
        return keyword;
    }
}