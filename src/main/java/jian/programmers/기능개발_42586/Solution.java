package jian.programmers.기능개발_42586;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		sol.solution(progresses, speeds);
	}

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
    	Queue<Integer> worktime = new LinkedList<Integer>();
    	
    	for (int i = 0; i < progresses.length; i++) {
    		int time = (100 - progresses[i]) / speeds[i];
    		
    		if ((100 - progresses[i]) % speeds[i] != 0) {
    			time++;
    		}
    		worktime.add(time);
    	}
    	
    	// [5, 10, 1, 1, 20, 1]
    	
    	List<Integer> result = new ArrayList<Integer>();
    	
    	int prevWork = worktime.poll();
    	
    	result = calcNextWork(prevWork, worktime);
    	
    	// TODO
    	
        return answer;
    }
    
    public List<Integer> calcNextWork(int newWork, Queue<Integer> newWorktime) {
    	Queue<Integer> worktime = newWorktime;
    	
    	List<Integer> result = new ArrayList<Integer>();
    	
    	// prevWork = 5
    	int prevWork = newWork;
    	
    	while (!worktime.isEmpty()) {
    		int total = 0;
    		int nextWork = worktime.poll();

    		if (prevWork < nextWork) {
    			total++;
    			
    		} else {
    			// TODO
    		}
    		
    		result.add(total);
    	}
    	
		return result;
    }
}
