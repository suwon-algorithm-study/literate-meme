package hose.programmers.codingStudy_2022_05_01;


import java.util.Scanner;

public class No1 {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        No1 no1 = new No1();
        no1.no1_main();
    }
    void no1_main() {
        int N = Integer.parseInt(in.nextLine());
        String answer = "";
        while(N > 0){
            //자꾸 1114, 114같이 나오는 오류가 발생.
            //1114, 114와 같이 나오는 이유는 다음자리로 넘어가는 경우역시 수의 카운트로 인정해줘야함.
            //4는 124규칙의 제일 마지막 수이므로 여기서 -1을 해주자.
            if(N % 3 == 0) {
                answer = "4" + answer;
                N--;
            }else if(N % 3 == 1) {
                answer = "1" + answer;
            }else {
                answer = "2" + answer;
            }
            N /= 3;
        }
        System.out.println(answer);
        //.......81 + 27 + 9 + 3
    }
}

