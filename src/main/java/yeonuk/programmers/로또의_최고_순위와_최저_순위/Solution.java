package yeonuk.programmers.로또의_최고_순위와_최저_순위;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    private final Map<Long, Integer> results = new HashMap<>();

    public Solution() {
        this.results.put(6L, 1);
        this.results.put(5L, 2);
        this.results.put(4L, 3);
        this.results.put(3L, 4);
        this.results.put(2L, 5);
        this.results.put(1L, 6);
        this.results.put(0L, 6);
    }

    public int[] solve(int[] lottos, int[] winNums) {
        List<String> winNumbers = Arrays.stream(winNums)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        List<String> lottoNumbers = Arrays.stream(lottos)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        long zeroCount = lottoNumbers.stream()
                .filter("0"::equals)
                .count();

        long matchCount = Arrays.stream(lottos)
                .mapToObj(String::valueOf)
                .filter(winNumbers::contains)
                .count();

        long max = getMax(zeroCount + matchCount);

        return new int[]{results.get(max), results.get(matchCount)};
    }

    private long getMax(long count) {
        return count >= 6 ? 6 : count;
    }
}
