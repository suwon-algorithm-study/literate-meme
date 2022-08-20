package seojeong.programmers.셔틀버스_리팩토링;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    /*
    1. 버스 클래스, 승객(직원) 클래스, 메인으로 구분
    2. 시간유틸은 LocalDate와 LocalTime, LocalDateTime 사용
     */

    /*
    입력:
     셔틀 운행 횟수 n,
     셔틀 운행 간격 t,
     한 셔틀에 탈 수 있는 최대 크루 수 m,
     크루가 대기열에 도착하는 시각을 모은 배열 timetable
     */
    /*


승객을 태우고 출발하고 등등 비즈니스는 메인에서
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        //String answer = solution.solution(1,1,5,new String[]{"08:00", "08:01", "08:02", "08:03"});
        String answer2 = solution.solution(10,60,45,new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"});
        //System.out.println(answer);
        System.out.println(answer2);
    }

    public String solution(int n, int t, int m, String[] timetable){

        // map: 스트림 내 요소들을 하나씩 특정 값으로 변환해줌
        // sorted: 인자없이 호출할 경우 기본 오름차순 정렬
        // collect(Collectors.toList()): 스트림에서 작업한 결과를 리스트로 반환

        LocalTime startTime = LocalTime.of(9,0);
        //System.out.println("버스 운행 시작 시간: " + startTime);

        //bussiness
        List<Passenger> list = Arrays.stream(timetable)
                .map(Passenger::new)
                .sorted()
                .collect(Collectors.toList());

        List<Bus> busList = new ArrayList<>();

        for(int i= 0; i<n; i++){
            // 버스 등장 -> 초기화시에 승객리스트는 빈 리스트로
            Bus bus = new Bus(startTime,m); // 버스 처음 운행시각, 태울 수 있는 최대 인원, 승객리스트

            // 여기 들어가기전에 tempList에 값이 있어야함
            List<Passenger> tempList = new ArrayList<>();
            for(Passenger passenger:list){
                if(bus.checkSize() && passenger.getArrivalTime().isBefore(startTime)){
                    bus.passengerRide(passenger);
                    tempList.add(passenger);
                }else{
                    break;
                }
            }
            list.removeAll(tempList);

            busList.add(bus);

            startTime = startTime.plusMinutes(t);
//
//            if(i == n-1){
//                if(!bus.checkSize()){
//                    result = bus.getLast().getArrivalTime().minusMinutes(1).toString();
//                }else{
//                    result = bus.getArrivalTime().toString();
//                }
//            }
        }
        Bus lastBus = busList.get(busList.size()-1);
        if(lastBus.checkSize()){
            return lastBus.getArrivalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        }
        return lastBus.getPossibleArrivalTime();
    }

}
class Bus{
    /*
    버스의 역할
    1. 도착시간 관리
    2. 최대인원 관리
    3. 도착(승객 탑승) -> 어떤 승객(시간으로 구분)이 탑승했는지??
     */

    private final LocalTime arrivalTime;
    private final int maxSize;
    // 버스에 탄 승객 리스트
    private List<Passenger> passengers;

    public Bus(LocalTime arrivalTime, int maxSize) {
        this.arrivalTime = arrivalTime;
        this.maxSize = maxSize;
        this.passengers = new ArrayList<>();
    }

    // 버스에 탈 수 있는 남은 자리가 있는지 체크
    // 남은 자리가 maxSize 보다 작은지 확인
    // 메서드 명을 의미있게?
    public boolean checkSize(){
        if(passengers.size() < maxSize) return true;
        else return false;
    }
    // 승객 태움
    public void passengerRide(Passenger passenger){
        this.passengers.add(passenger);
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
    // 마지막 탑승자
    public Passenger getLast(){
        return passengers.get(passengers.size()-1);
    }

    // 탑승할 수 있는 마지막 시간
    public String getPossibleArrivalTime(){
        Passenger lastPassenger = passengers.get(passengers.size()-1);
        return lastPassenger.getArrivalTime().minusMinutes(1).format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
class Passenger implements Comparable<Passenger>{
    /*
    1. 도착시간 관리
     */
    private LocalTime arrivalTime;

    // string 타입으로 들어오는 시간을 -> Localtime으로
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    public Passenger(String time){
        arrivalTime = LocalTime.parse(time,formatter);
    }

    // 승객 도착시간
    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public int compareTo(Passenger o) {
        return this.arrivalTime.compareTo(o.arrivalTime);
    }
}
