package jian.programmers.키패드누르기_67256;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public String solution(int[] numbers, String hand) {
        int prevL = 10; 
        int prevR = 12;
        String baseHand = "left".equals(hand) ? "L" : "R";

        String answer = "";

        for (int i = 0; i < numbers.length; i++) {
            Keypad keypad = new Keypad();

            for (int j = 0; j < keypad.getKeypad().size(); j++) {
                int indexOf = Arrays.asList(keypad.getKeypad().get(j))
                                    .indexOf((Object)numbers[i]);

                if (indexOf != -1) {
                    switch (j) {
                        case 0:
                            prevL = numbers[i];
                            hand = "L";
                            break;
                        case 1:
                            int leftInstance = getInstance(numbers[i], prevL);
                            int rigtInstance = getInstance(numbers[i], prevR);
                            
                            if (leftInstance == rigtInstance) {
                            	hand = baseHand;
                                if ("L".equals(baseHand)) {
                                    prevL = numbers[i];
                                } else {
                                    prevR = numbers[i];
                                }
                                
                            } else if (leftInstance < rigtInstance) {
                            	hand = "L";
                                prevL = numbers[i];
                            } else {
                            	hand = "R";
                                prevR = numbers[i];
                            }
                            break;
                        case 2:
                            prevR = numbers[i];
                            hand = "R";
                            break;
                    }
                    break;
                }
            }
            answer += hand;
        }

        return answer;
    }

	public int getInstance(int number, int prev) {
		if (number == 0) number = 11;

		if (prev == 0) prev = 11;

		int row = Math.abs(number - prev) / 3;
		int col = Math.abs(number - prev) % 3;

		return row + col;
	}

    class Keypad {
        List<Object[]> keypad;

        public Keypad() {
            keypad = new ArrayList<>();
            keypad.add(new Object[]{1, 4, 7, 10});
            keypad.add(new Object[]{2, 5, 8, 11});
            keypad.add(new Object[]{3, 6, 9, 12});
        }

        public void setKeypad(List<Object[]> keypad) {
            this.keypad = keypad;
        }

        public List<Object[]> getKeypad() {
            return keypad;
        }
    }
}
