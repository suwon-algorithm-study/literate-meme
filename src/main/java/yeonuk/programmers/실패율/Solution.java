package yeonuk.programmers.실패율;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(int N, int[] stages) {

        int peopleCount = stages.length;
        double[] results = new double[N];

        List<Answer> answers = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            int stageCount = 0;
            for (int stage : stages) {
                if (stage == i) {
                    stageCount++;
                }
            }
            results[i - 1] = (double) stageCount / (double) peopleCount;
            Answer answer = new Answer(i, results[i - 1]);
            answers.add(answer);

            peopleCount -= stageCount;
        }

        return answers.stream()
                .sorted()
                .mapToInt(Answer::getIndex)
                .toArray();
    }
}

class Answer implements Comparable<Answer> {

    private final int index;
    private final double value;

    public Answer(int index, double value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(Answer o) {
        if (this.value < o.value) {
            return 1;
        } else if (this.value > o.value) {
            return -1;
        } else {
            return 1;
        }
    }
}