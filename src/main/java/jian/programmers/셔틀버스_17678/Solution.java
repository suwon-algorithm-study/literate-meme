package jian.programmers.셔틀버스_17678;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] str = {"09:00", "09:10" ,"09:20" ,"09:30" ,"09:40" ,"09:50", "10:00", "10:10" ,"10:20" ,"10:30" ,"10:40" ,"10:50"};
        String answer = sol.solution(10, 25, 1, str);
        System.out.println(answer);
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        Bus bus = new Bus();
        bus.setArrivedTime(n, t);          // 버스 도착시간
        bus.setMaxCnt(m);                  // 버스 최대인원수

        Employee employee = new Employee();
        employee.setTimeTable(timetable);  // 직원 도착시간

        for (int i = 0; i < n; i++) {
            LocalTime busTime = bus.arrivedTime.get(i);
            List<LocalTime> employeeTable = employee.getTimeTable();

            LocalTime nextEmployee = employee.getTimeTable().get(0);

            while (!employeeTable.isEmpty()) {
                LocalTime arrivedTime = employeeTable.get(0);

                if (bus.isRemain() && (arrivedTime.isBefore(busTime) || arrivedTime.equals(busTime))) {
                    bus.pickUpEmployee();
                    nextEmployee = employee.getTimeTable().get(0);
                    employee.getTimeTable().remove(0);

                } else {
                    if (i != n - 1) {
                        bus.setCurCnt(0);
                    }
                    break;
                }
            }

            if (i == n - 1) {
                if (bus.isRemain()) {
                    answer = String.valueOf(bus.arrivedTime.get(i));

                } else {
                    answer = String.valueOf(nextEmployee.minusMinutes(1));
                }
            }
        }

        return answer;
    }

    class Bus {
        List<LocalTime> arrivedTime = new ArrayList<>();
        int maxCnt;
        int curCnt = 0;

        public int getCurCnt() {
            return curCnt;
        }

        public void setCurCnt(int curCnt) {
            this.curCnt = curCnt;
        }

        public List<LocalTime> getArrivedTime() {
            return arrivedTime;
        }

        public boolean isRemain() {
            if (curCnt == maxCnt) {
                return false;
            }

            return true;
        }

        public void pickUpEmployee() {
            curCnt++;
        }

        public void setArrivedTime(int n, int t) {
            LocalTime initTime = LocalTime.of(9, 00);
            this.arrivedTime.add(initTime);

            for (int i = 1; i < n; i++) {
                initTime = initTime.plusMinutes(t);
                this.arrivedTime.add(initTime);
            }
        }

        public int getMaxCnt() {
            return maxCnt;
        }

        public void setMaxCnt(int maxCnt) {
            this.maxCnt = maxCnt;
        }
    }

    class Employee {
        List<LocalTime> timeTable = new ArrayList<>();

        public List<LocalTime> getTimeTable() {
            return timeTable;
        }

        public void setTimeTable(String[] timetable) {
            List<String> tTable = Arrays.stream(timetable)
                    .sorted()
                    .collect(Collectors.toList());

            for (int i = 0; i < tTable.size(); i++) {
                LocalTime localTime = LocalTime.parse(tTable.get(i));
                this.timeTable.add(localTime);
            }
        }

        public void setTimeTable(List<LocalTime> timeTable) {
            this.timeTable = timeTable;
        }
    }
}