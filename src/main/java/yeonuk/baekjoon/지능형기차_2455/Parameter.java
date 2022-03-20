package yeonuk.baekjoon.지능형기차_2455;

public class Parameter {

    private int source1;
    private int destination1;

    private int source2;
    private int destination2;

    private int source3;
    private int destination3;

    private int source4;
    private int destination4;

    private int max;
    private int current;

    public Parameter(int source1, int destination1, int source2, int destination2, int source3, int destination3, int source4, int destination4) {
        this.source1 = source1;
        this.destination1 = destination1;
        this.source2 = source2;
        this.destination2 = destination2;
        this.source3 = source3;
        this.destination3 = destination3;
        this.source4 = source4;
        this.destination4 = destination4;
        this.max = destination1;
        this.current = destination1;
    }

    public int getSource1() {
        return source1;
    }

    public int getDestination1() {
        return destination1;
    }

    public int getSource2() {
        return source2;
    }

    public int getDestination2() {
        return destination2;
    }

    public int getSource3() {
        return source3;
    }

    public int getDestination3() {
        return destination3;
    }

    public int getSource4() {
        return source4;
    }

    public int getDestination4() {
        return destination4;
    }

    public int getMax() {
        return max;
    }

    public int getCurrent() {
        return current;
    }

    public void updateMax() {
        this.max = this.current;
    }

    public void updateCurrent(int current) {
        this.current = current;
    }
}
