package seojeong.programmers.Baekjoon1931;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings = new ArrayList<>();
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }
        Collections.sort(meetings);
        int result = 1;

        Meeting before = meetings.get(0);
        for(int i=1; i<meetings.size(); i++){
            Meeting current = meetings.get(i);

            if(before.end <= current.start){
                result += 1;
                before = meetings.get(i);
            }
        }
        System.out.println(result);

        for(Meeting val:meetings){
            System.out.print("("+val.start+" "+val.end+")"+" ");
        }

    }
}
class Meeting implements Comparable<Meeting>{
    int start;
    int end;
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int compareTo(Meeting m) {
        if(this.end==m.end) {
            return Integer.compare(this.start,m.start);
        }
        else {
            return Integer.compare(this.end,m.end);
        }
    }

}
