package hose.programmers.codingStudy_2022_04_10;

import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String prob = in.nextLine();
        checkAllCase(prob);
    }
    static void checkAllCase(String prob) {
        prob = checkCaseOne(prob);
        prob = checkCaseTwo(prob);
        prob = checkCaseThree(prob);
        prob = checkCaseFour(prob);
        prob = checkCaseFive(prob);
        prob = checkCaseSix(prob);
        prob = checkCaseSeven(prob);
    }
    static String checkCaseOne(String info) {
        String result = info.toLowerCase();
        System.out.println("case1: " + result);
        return result;
    }
    static String checkCaseTwo(String info) {
        String match = "[^0-9a-zA-Z._-]";
        String result = info.replaceAll(match, "");
        System.out.println("case2: " + result);
        return result;
    }
    static String checkCaseThree(String info) {
        for(int i = 0; i < info.length(); i++) {
            if(info.substring(i, i + 1).equals(".")) {
                int counter = 1;
                for(int j = i + 1; j < info.length(); j++) {
                    if(info.substring(j, j + 1).equals("."))
                        counter++;
                    if(!info.substring(j, j + 1).equals(".") && counter >= 2) {
                        if(i == 0) {
                            info = info.substring(0, 1) + info.substring(j, info.length());
                        }
                        else {
                            info = info.substring(0, i) + info.substring(j, info.length());
                        }
                        break;
                    }
                }
            }
        }
        System.out.println("case3: " + info);
        return info;
    }
    static String checkCaseFour(String info) {
        if(info.substring(0, 1).equals("."))
            info = info.substring(1, info.length());
        if(info.substring(info.length() - 1, info.length()).equals("."))
            info = info.substring(0, info.length() - 1);
        System.out.println("case4: " + info);
        return info;
    }
    static String checkCaseFive(String info) {
        if(info.length() == 0) {
            info = "a";
        }
        System.out.println("case5: " + info);
        return info;
    }
    static String checkCaseSix(String info) {
        if(info.length() > 15) {
            info = info.substring(0, 15);
            while(info.substring(info.length() - 1, info.length()).equals(".")) {
                info = info.substring(0, info.length() - 1);
            }
        }
        System.out.println("case6: " + info);
        return info;
    }
    static String checkCaseSeven(String info) {
        if(info.length() < 3) {
            while(info.length() != 3) {
                info = info + info.substring(info.length() - 1, info.length());
            }
        }
        System.out.println("case7: " + info);
        return info;
    }
}