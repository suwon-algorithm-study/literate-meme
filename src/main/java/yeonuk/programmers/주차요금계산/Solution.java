package yeonuk.programmers.주차요금계산;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        ParkingLot parkingLot = new ParkingLot(fees);

        for (String record : records) {
            String[] recordArray = record.split(" ");

            LocalTime parkTime = getParkTime(recordArray[0]);

            String carNumber = recordArray[1];

            ParkingType parkingType = ParkingType.findByText(recordArray[2]);

            if (parkingType == ParkingType.IN) {
                ParkingHistory parkingHistory = new ParkingHistory(carNumber, parkTime);
                ParkingCar parkingCar = new ParkingCar(carNumber);
                parkingLot.park(parkingHistory, parkingCar);

            } else if (parkingType == ParkingType.OUT) {
                ParkingHistory parkingHistory = parkingLot.findLastParkingHistory(carNumber);
                parkingHistory.exit(parkTime);
            }
        }

        parkingLot.forceExit();

        parkingLot.imposeParkingFee();

        return parkingLot.getParkingCars()
                .stream()
                .sorted(Comparator.comparing(ParkingCar::getCarNumber))
                .map(ParkingCar::getParkingFee)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private LocalTime getParkTime(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        return LocalTime.of(hour, minute);
    }
}

class ParkingLot {

    private final ParkingFee parkingFee;

    private List<ParkingHistory> parkingHistoryList;

    private List<ParkingCar> parkingCars;

    public ParkingLot(int[] fees) {
        this.parkingFee = new ParkingFee(fees);
        parkingHistoryList = new ArrayList<>();
        parkingCars = new ArrayList<>();
    }

    public void park(ParkingHistory parkingHistory, ParkingCar parkingCar) {
        parkingHistoryList.add(parkingHistory);
        if (parkingCars.stream()
                .noneMatch(car -> car.getCarNumber().equals(parkingCar.getCarNumber()))) {
            parkingCars.add(parkingCar);
        }
    }

    public ParkingHistory findLastParkingHistory(String carNumber) {
        return parkingHistoryList.stream()
                .filter(car -> car.equalsCarNumber(carNumber))
                .filter(ParkingHistory::isRemain)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입차기록이 없습니다."));
    }

    public List<ParkingHistory> findAllParkingCars(String carNumber) {
        return parkingHistoryList.stream()
                .filter(car -> car.equalsCarNumber(carNumber))
                .collect(Collectors.toList());
    }

    public void forceExit() {
        parkingHistoryList.stream()
                .filter(ParkingHistory::isRemain)
                .forEach(ParkingHistory::forceExit);
    }

    public void imposeParkingFee() {
        for (ParkingCar parkingCar : parkingCars) {
            List<ParkingHistory> parkingCars = findAllParkingCars(parkingCar.getCarNumber());
            int parkingTime = parkingCars.stream()
                    .map(ParkingHistory::getParkingTime)
                    .mapToInt(Integer::intValue)
                    .sum();

            int imposeFee = parkingFee.getBaseFee();

            if (parkingFee.getBaseTime() < parkingTime) {
                int additionalParkingTime = parkingTime - parkingFee.getBaseTime();
                int ceilAdditionalTime = (int) Math.ceil((double) additionalParkingTime / (double) parkingFee.getAdditionalTime());
                parkingTime += ceilAdditionalTime;
                imposeFee += ceilAdditionalTime * parkingFee.getAdditionalFee();
            }
            parkingCar.imposeFee(parkingTime, imposeFee);
        }
    }

    public List<ParkingCar> getParkingCars() {
        return parkingCars;
    }
}

enum ParkingType {
    IN("IN"),
    OUT("OUT");

    private final String text;

    ParkingType(String text) {
        this.text = text;
    }

    public static ParkingType findByText(String text) {
        return Arrays.stream(values())
                .filter(value -> value.text.equals(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("허용되지 않은 타입 text=" + text));
    }
}

class ParkingFee {

    private final int baseTime;

    private final int baseFee;

    private final int additionalTime;

    private final int additionalFee;

    public ParkingFee(int[] fees) {
        this.baseTime = fees[0];
        this.baseFee = fees[1];
        this.additionalTime = fees[2];
        this.additionalFee = fees[3];
    }

    public int getBaseTime() {
        return baseTime;
    }

    public int getBaseFee() {
        return baseFee;
    }

    public int getAdditionalTime() {
        return additionalTime;
    }

    public int getAdditionalFee() {
        return additionalFee;
    }

}

class ParkingHistory {

    private final String carNumber;

    private final LocalTime entranceTime;

    private LocalTime exitTime;

    public ParkingHistory(String carNumber, LocalTime entranceTime) {
        this.carNumber = carNumber;
        this.entranceTime = entranceTime;
    }

    public void exit(LocalTime time) {
        this.exitTime = time;
    }

    public boolean equalsCarNumber(String carNumber) {
        return this.carNumber.equals(carNumber);
    }

    public boolean isRemain() {
        return this.exitTime == null;
    }

    public void forceExit() {
        this.exitTime = LocalTime.of(23, 59);
    }

    public int getParkingTime() {
        return (int) Duration.between(entranceTime, exitTime)
                .toMinutes();
    }

}

class ParkingCar {

    private final String carNumber;

    private int parkingTime;

    private int parkingFee;

    public ParkingCar(String carNumber) {
        this.carNumber = carNumber;
    }

    public void imposeFee(int parkingTime, int paringFee) {
        this.parkingTime = parkingTime;
        this.parkingFee = paringFee;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getParkingFee() {
        return parkingFee;
    }

    public int getParkingTime() {
        return parkingTime;
    }
}