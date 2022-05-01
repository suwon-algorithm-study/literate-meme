package hose.programmers.codingStudy_2022_05_01;

import java.util.Scanner;

public class No2 {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        No2 no2 = new No2();
        no2.no2_main();
    }
    void no2_main() {
        StringBuilder sbLine = new StringBuilder();
        //replace 함수의 활용을 위한 스트링빌더를 활용
        String line = in.nextLine();
        sbLine.append(line);
        //입력받은 문자를 스트링 빌더에 저장.
        int pointer = 0;
        //포인터값을 통해 천천히 값을 비교해나갈 예정이다.
        while(true) {
            if(sbLine.length() < pointer + 2)
                break;
            if((sbLine.charAt(pointer) == sbLine.charAt(pointer + 1))) {
                sbLine = sbLine.replace(pointer, pointer + 2, ""); //이녀석이 만악의 근원같은데
                System.out.println(sbLine);
                pointer = 0;
            }
            else
                pointer++;
        }
        if(sbLine.length() == 0) {
            System.out.println(1);
        }
        else
            System.out.println(0);
    }
}
