package hose.programmers.codingStudy_2022_03_27;

import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] checker = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < 10; i++) {
            System.out.println(checker[i].length());
            for(int j = 0; j <= str.length() - checker[i].length(); j++) {
                if(str.substring(j, j + checker[i].length()).contains(checker[i])) {
                    str = str.replaceAll(str.substring(j, j + checker[i].length()),  Integer.toString(i));
                }
            }
        }
        System.out.println(str);
    }
}