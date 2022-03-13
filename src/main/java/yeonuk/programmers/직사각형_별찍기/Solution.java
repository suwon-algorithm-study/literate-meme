package yeonuk.programmers.직사각형_별찍기;

import java.util.Scanner;

public class Solution {

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.solve(args);
//    }

    public void solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                result.append("*");
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}
