package hose.programmers.codingStudy_2022_04_10;

import java.util.Arrays;
import java.util.Scanner;

public class No3 {
    static String[] checkAlphabet = new String[26];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String prob = in.nextLine();
        for(int i = 0; i < prob.length(); i++) {
        }
    }
    static boolean findElement(String element) {
        for(int i = 0; i < 26; i++) {
            if(checkAlphabet[i] == "") {
                return true;
            }
        }
        return false;
    }
    String sortAlphabet(String str){
        String[] temp = str.split("");
        Arrays.sort(temp);

        String change = "";
        for (int i = 0; i < temp.length; i++) {
            change += temp[i];
        }

        return change;
    }
}