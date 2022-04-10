package byungrok.programmers;

public class programmers_신규_아이디_추천 {
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
	}
	public static String solution(String new_id) {
        String answer = new_id;
        
        answer = answer.toLowerCase();
        answer  =  answer.replaceAll("[^a-z0-9-_.]", "");
        String temp = "";
        for(int i=0; i<answer.length(); i++) {
        	char c = answer.charAt(i);
        	temp+=c;
        	if(c=='.') while(i+1<answer.length() && '.'==answer.charAt(i+1)) i++; 
        }
        answer = temp;
        while(answer.startsWith(".")) answer = answer.substring(1, answer.length());
        while(answer.endsWith(".")) answer = answer.substring(0, answer.length()-1);
        if("".equals(answer)) answer = "a";
        if(answer.length() > 15) answer = answer.substring(0, 15);
        while(answer.endsWith(".")) answer = answer.substring(0, answer.length()-1);
        while(answer.length() < 3) answer+=answer.charAt(answer.length()-1);
        
        return answer;
    }
}
