package jian.baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * BAEKJOON 15953번: 상금 헌터
 * @since 2022. 05. 22
 * @author jian
 *
 */
public class baejoon15953 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Scanner input = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        for (int i=0; i < t; i++) {
        	input = new Scanner(System.in);
            StringTokenizer token = new StringTokenizer(input.nextLine(), " ");
            
            input(token);
        }

        input.close();
        scanner.close();
    }
    
    public static void input(StringTokenizer token) {
        int a = Integer.valueOf(token.nextToken());    // 제1회 페스티벌
        int b = Integer.valueOf(token.nextToken()); // 제2회 페스티벌
        
        int aPerson = 21;
        int bPerson = 31;
        
        int[][] aList = {{1, 2, 3, 4, 5, 6}, {5000000, 3000000, 2000000, 500000, 300000, 100000}};
        int[][] bList = {{1, 2, 4, 8, 16}, {5120000, 2560000, 1280000, 640000, 320000}};
        
        System.out.println(calc(a, aPerson, aList)+calc(b, bPerson, bList));
    }
    
    /* 본선 진출 calc */
    public static int calc(int p, int person, int[][] list) {
        int totalPrize = 0; // 총 상금
        
        if (p < person && p != 0) {
            int temp = 0;
            
            for (int i=0; i < list[0].length; i++) {
                temp += list[0][i];
                
                if (p < temp) {
                    totalPrize += list[1][i];
                    
                    return totalPrize;
                }
            }
        }
        return totalPrize;
    }

}
