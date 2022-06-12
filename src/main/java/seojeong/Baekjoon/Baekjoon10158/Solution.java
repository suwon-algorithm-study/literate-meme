package seojeong.programmers.Baekjoon10158;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int x = (p + t) / w;
        int y = (q + t) / h;

        if(x%2 == 0){
            x = (p+t) % w;
        }
        else{
            x = w - (p+t) % w;
        }

        if(y%2 == 0){
            y = (q+t) % h;
        }
        else{
            y = h - (q+t) % h;
        }

        sb.append(x).append(" ").append(y);
        System.out.println(sb);

    }
}
