package byungrok.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class programmers_파일명정렬 {
	public static void main(String[] args){
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		파일명정렬 sol = new 파일명정렬();
		System.out.println(sol.solution(files));
	}
}
class 파일명정렬 {
    public String[] solution(String[] files) {
    	String[] answer = {};
        List<File> fileList = new ArrayList<File>();
        
        for(int i=0; i<files.length; i++) {
        	String file = files[i];
        	
        	String[] fileNameSplit = new String[3];//[head, number, tail]
        	Arrays.fill(fileNameSplit, "");
        	int spIdx = 0;
        	boolean isDigit = Character.isDigit(file.charAt(0));
        	
        	for(int c=0; c<file.length(); c++) {
        		if(spIdx<2 && isDigit ^ Character.isDigit(file.charAt(c))) {
        			isDigit = !isDigit;
        			spIdx++;
        		}
        		fileNameSplit[spIdx] +=file.charAt(c); 
        	}
        	
        	fileList.add(new File(fileNameSplit[0].toLowerCase(), Integer.parseInt(fileNameSplit[1]), fileNameSplit[2], i));
        }
        
        Collections.sort(fileList);
        
        answer = new String[files.length];
        int idx = 0;
        for(File file : fileList) {
        	answer[idx++] = files[file.ogIndex];
        }
        return answer;
    }
    
    class File implements Comparable<File>{
    	String head;
    	int number;
    	String tail;
    	int ogIndex;
		public File(String head, int number, String tail, int ogIndex) {
			super();
			this.head = head;
			this.number = number;
			this.tail = tail;
			this.ogIndex = ogIndex;
		}
		@Override
		public int compareTo(File o) {
			if(head.equals(o.head)) {
				if(number == o.number) {
					return ogIndex - o.ogIndex;
				}
				return number - o.number;
			}
			return head.compareTo(o.head);
		}
    	
    }
}
