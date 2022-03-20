package yeonuk.baekjoon.오븐시계_2525;

public class Parameter {

    private int hour;
    private int minute;

    private int time;

    public Parameter(int hour, int minute, int time) {
        this.hour = hour;
        this.minute = minute;
        this.time = time;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getTime() {
        return time;
    }

    public void plusHour() {
        this.hour += this.minute / 60;
    }

    public boolean overHour() {
        return this.hour >= 24;
    }

    public void minusHour() {
        this.hour -= 24;
    }

    public void remainMinute() {
        this.minute %= 60;
    }

    public void plusMinute() {
        this.minute += time;
    }

    public boolean overMinute() {
        return this.minute >= 60;
    }
}
