package yeonuk.baekjoon.오븐시계_2525;

public class Solution {

    public Answer solve(Parameter parameter) {
        parameter.plusMinute();
        if (parameter.overMinute()) {
            parameter.plusHour();
            if (parameter.overHour()) {
                parameter.minusHour();
            }
            parameter.remainMinute();
        }

        return new Answer(parameter.getHour(), parameter.getMinute());
    }

}
