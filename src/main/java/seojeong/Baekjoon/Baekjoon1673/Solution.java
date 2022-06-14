package seojeong.programmers.Baekjoon1673;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 쿠폰
        int k = Integer.parseInt(st.nextToken()); // 도장

        int result = 0;
        result += n;

        int res = 0;

        while(n >= k) {
            result += n/k;
            res += n%k;
            n /= k;
        }
        if(res >= k){
            res %= k;

        }

        System.out.println(result);

    }
}

