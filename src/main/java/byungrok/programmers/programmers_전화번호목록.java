package byungrok.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class programmers_전화번호목록 {
	public boolean solution2(String[] phone_book) {
		boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=1; i<phone_book.length; i++) {
        	if(phone_book[i].startsWith(phone_book[i-1])) {
        		answer = false;
        		break;
        	}
        }
        return answer;
	}
	
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		Node root = new Node(false);
		
		for(String pNum : phone_book) {
			Node cur = root;
			for(Character c : pNum.toCharArray()) {
				Integer num = c -'0';
				if(cur.children[num] == null) {
					cur.children[num] = new Node(false);
				}
				if(cur.isLast) {
					answer = false;
					break;
				}
				cur.hasMore = true;
				cur = cur.children[num];
			}
			if(!answer || cur.hasMore) {
				answer = false;
				break;
			}
			
			cur.isLast = true;
		}
		
		return answer;
	}
}

class Node {
	boolean isLast;
	boolean hasMore;
	Node[] children;
	public Node(boolean isLast) {
		super();
		this.isLast = isLast;
		this.hasMore = false;
		this.children = new Node[10];
	}
	
}
