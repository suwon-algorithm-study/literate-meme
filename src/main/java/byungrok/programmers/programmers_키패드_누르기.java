package byungrok.programmers;

public class programmers_키패드_누르기 {
	public String solution(int[] numbers, String hand) {
        String answer = "";
        
        Hand right = new Hand();
        Hand left = new Hand();
        
        for(int number : numbers) {
        	number -= 1;
        	int line = number%3;
        	
        	int to = number/3;
        	Hand use = null;
        	boolean isMiddle = false;
        	
        	if(number == -1 || line == 1) {
        		to = number == -1 ? 3 : to;
        		isMiddle = true;
        		
        		int fromL = Math.abs(left.getPosition() - to) + (left.isMiddle() ? 0 : 1);
        		int fromR = Math.abs(right.getPosition() - to) + (right.isMiddle() ? 0 : 1);
        		
        		if(fromL < fromR) {
        			use = left;
        		}else if(fromL > fromR) {
        			use = right;
        		}else {
        			use = "right".equals(hand) ? right : left;
        		}
        		
        	}else {
        		use = line == 0 ? left : right;
        	}
        	
        	use.moveTo(to, isMiddle);
        	answer += right.equals(use) ? "R" : "L";
        }
        
        return answer;
    }
}
class Hand{
	private int position;
	private boolean isMiddle;
	
	public Hand() {
		super();
		this.position = 3;
		this.isMiddle = false;
	}
	
	public void moveTo(int position, boolean isMiddle) {
		this.position = position;
		this.isMiddle = isMiddle;
	}

	public int getPosition() {
		return position;
	}

	public boolean isMiddle() {
		return isMiddle;
	}
	
}
