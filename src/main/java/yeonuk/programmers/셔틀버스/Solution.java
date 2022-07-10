package yeonuk.programmers.셔틀버스;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        List<Passenger> passengers = Arrays.stream(timetable)
                .map(Passenger::new)
                .sorted()
                .collect(Collectors.toList());

        List<Bus> busList = new ArrayList<>();
        LocalTime arriveTime = LocalTime.of(9, 0);
        for (int i = 0; i < n; i++) {
            Bus bus = new Bus(arriveTime, m);


            List<Passenger> temp = new ArrayList<>();
            for (Passenger passenger : passengers) {
                if (bus.isRemain() && passenger.getArriveTime().isBefore(bus.getMaxTime())) {
                    bus.ride(passenger);
                    temp.add(passenger);
                } else {
                    break;
                }
            }
            passengers.removeAll(temp);

            busList.add(bus);

            arriveTime = arriveTime.plusMinutes(t);
        }

        Bus lastBus = busList.get(busList.size() - 1);

        if (lastBus.isRemain()) {
            return lastBus.getArriveTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        }
        return lastBus.getPossibleArriveTime();
    }
}

class Bus {

    private final LocalTime arriveTime;

    private final int fullSize;

    private List<Passenger> passengers;


    public Bus(LocalTime arriveTime, int fullSize) {
        this.arriveTime = arriveTime;
        this.fullSize = fullSize;
        this.passengers = new ArrayList<>();
    }

    public boolean isRemain() {
        return passengers.size() < fullSize;
    }

    public void ride(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public LocalTime getArriveTime() {
        return arriveTime;
    }

    public LocalTime getMaxTime() {
        return arriveTime.plusMinutes(1);
    }

    public String getPossibleArriveTime() {
        Passenger lastPassenger = this.passengers.get(passengers.size() - 1);
        return lastPassenger.getArriveTime()
                .minusMinutes(1)
                .format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}

class Passenger implements Comparable<Passenger> {

    private final LocalTime arriveTime;

    public Passenger(String time) {
        arriveTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    }

    public LocalTime getArriveTime() {
        return arriveTime;
    }

    @Override
    public int compareTo(Passenger o) {
        return this.arriveTime.compareTo(o.arriveTime);
    }
}