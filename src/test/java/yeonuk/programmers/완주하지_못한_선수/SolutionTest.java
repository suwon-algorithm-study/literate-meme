package yeonuk.programmers.완주하지_못한_선수;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}, "leo"),
                Arguments.of(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}, "vinko"),
                Arguments.of(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}, "mislav")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("provideArguments")
    @DisplayName("완주하지 못한 선수")
    void test(String[] participant, String[] completion, String expect) {
        //given
        Solution solution = new Solution();

        //when
        String actual = solution.solve(participant, completion);

        //then
        assertEquals(actual, expect);
    }
}