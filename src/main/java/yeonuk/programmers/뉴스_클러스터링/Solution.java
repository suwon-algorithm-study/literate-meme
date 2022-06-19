package yeonuk.programmers.뉴스_클러스터링;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int solution(String str1, String str2) {
        Cluster cluster = new Cluster(str1, str2);
        List<String> unionWords = cluster.getUnion();
        List<String> intersectionWords = cluster.getIntersection();

        if (unionWords.isEmpty()) {
            return 65536;
        }

        double numerator = intersectionWords.size();
        double denominator = unionWords.size();

        double result = numerator / denominator;

        return (int) (result * 65536);
    }
}

class Cluster {

    private final List<String> firstWords;
    private final List<String> secondWords;

    public Cluster(String firstWord, String secondWord) {
        firstWords = new ArrayList<>();
        secondWords = new ArrayList<>();

        init(firstWords, firstWord);
        init(secondWords, secondWord);
    }

    public void init(List<String> words, String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            char firstChar = word.charAt(i);
            char secondChar = word.charAt(i + 1);

            if (Character.isAlphabetic(firstChar) && Character.isAlphabetic(secondChar)) {
                String sliceWord = Stream.of(firstChar, secondChar)
                        .map(String::valueOf)
                        .collect(Collectors.joining());
                String lowerWord = sliceWord.toLowerCase();
                words.add(lowerWord);
            }
        }
    }

    public List<String> getUnion() {
        List<String> concatWords = Stream.of(firstWords, secondWords)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<String> intersection = getIntersection();
        for (String word : intersection) {
            concatWords.remove(word);
        }
        return concatWords;
    }

    public List<String> getIntersection() {
        List<String> firstTempWords = new ArrayList<>(firstWords);

        List<String> intersectionList = new ArrayList<>();
        for (String secondWord : secondWords) {
            if (firstTempWords.contains(secondWord)) {
                firstTempWords.remove(secondWord);
                intersectionList.add(secondWord);
            }
        }

        return intersectionList;
    }
}