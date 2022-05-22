package seojeong.programmers.Baekjoon1713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student>{
    public int num;
    public int count;
    public int time;

    public Student(int num, int count, int time){
        this.num = num;
        this.count = count;
        this.time = time;
    }

    @Override
    public int compareTo(Student o) {
        if(this.count == o.count){
            //먼저 들어온애(시간 값 작은애)부터 정렬 -> 오름 차순
            return this.time - o.time;
        }else if(this.count < o.count){
            return -1;
        }
        return 1;
    }
}


public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] students = new int[101]; //추천수 저장
        List<Student> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int student = Integer.parseInt(st.nextToken()); //추천받은 학생 번호
            if(students[student] > 0) { //4. 현재 사진이 게시된 학생이 다른 학생의 추천을 받는 경우 추천받은 횟수만 증가
                students[student] += 1; //추천수 추가
                for(int j=0; j<list.size(); j++){ // 액자 정보를 list에도 넣어놔서 여기도 값 수정
                    if(list.get(j).num == student){
                        list.get(j).count += 1;
                        break;
                    }
                }

            }else{
                //이미 액자가 차있을 경우 -> 1.액자에 있는 애들 중 추천수가 가장 작은애 2. 두명이상이면 오래된애
                if(list.size() >= n){
                    Collections.sort(list); // 정렬
                    int num = list.get(0).num; //학생 번호
                    //5. 사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀜
                    students[num] = 0;
                    list.remove(0);
                }
                //액자가 아직 안차있는 경우
                list.add(new Student(student,1,i));
                students[student] = 1;
            }
        }

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.num - o2.num;
            }
        });
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i).num+" ");
        }
    }
}
