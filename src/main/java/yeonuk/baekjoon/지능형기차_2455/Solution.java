package yeonuk.baekjoon.지능형기차_2455;

public class Solution {


    public int solve(Parameter parameter) {
        int newCurrent2 = parameter.getCurrent() - parameter.getSource2() + parameter.getDestination2();
        updateMax(parameter, newCurrent2);

        int newCurrent3 = parameter.getCurrent() - parameter.getSource3() + parameter.getDestination3();
        updateMax(parameter, newCurrent3);

        int newCurrent4 = parameter.getCurrent() - parameter.getSource4() + parameter.getDestination4();
        updateMax(parameter, newCurrent4);

        return parameter.getMax();
    }

    private void updateMax(Parameter parameter, int newCurrent) {
        parameter.updateCurrent(newCurrent);
        if (parameter.getMax() < parameter.getCurrent()) {
            parameter.updateMax();
        }
    }
}
