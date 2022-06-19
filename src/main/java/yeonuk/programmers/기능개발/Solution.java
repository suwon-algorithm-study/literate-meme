package yeonuk.programmers.기능개발;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            Task task = new Task(progress, speed);
            taskList.add(task);
        }

        List<Integer> answer = new ArrayList<>();

        int max = 0;
        int count = 1;
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            int deployDateCount = task.getDeployDateCount();
            if (i == 0) {
                max = deployDateCount;
            } else if (max >= deployDateCount) {
                count += 1;
            } else {
                answer.add(count);
                count = 1;
                max = deployDateCount;
            }

            if (i == taskList.size() - 1) {
                answer.add(count);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

class Task {

    private static final int MAX_PROGRESS = 100;

    private final int progress;
    private final int speed;

    public Task(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }

    public int getDeployDateCount() {
        return (int) Math.ceil((double) (MAX_PROGRESS - progress) / (double) speed);
    }
}