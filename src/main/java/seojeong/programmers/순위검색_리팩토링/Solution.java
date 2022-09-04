package seojeong.programmers.순위검색_리팩토링;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        Solution solution = new Solution();

        int[] ans = solution.solution(info,query);
        for (int an : ans) {
            System.out.print(an+ " ");
        }

    }
    public int[] solution(String[] info, String[] query){
        List<Applicant> applicants = new ArrayList<>();

        for(String temp:info){
            String[] infos = temp.split(" ");
            Language language = Language.findByValue(infos[0]);
            Position position = Position.findByValue(infos[1]);
            Career career = Career.findByValue(infos[2]);
            Food food = Food.findByValue(infos[3]);
            int score = Integer.parseInt(infos[4]);

            Applicant applicant = new Applicant(language,position,career,food,score);
            applicants.add(applicant);
        }
        // 확인
//        for (Applicant applicant : applicants) {
//            System.out.println("지원언어: " + applicant.language +
//                                " 포지션: " + applicant.position +
//                                " 경력 구분: " + applicant.career +
//                                " 선호 음식: " + applicant.food +
//                                " 코딩테스트 점수: " + applicant.score);
//        }
        // 점수 순으로 지원자 배열 정렬
        applicants.sort((o1, o2) -> o1.score >= o2.score ? 1:-1);
        List<Integer> answer = new ArrayList<>();

//        System.out.println("점수대로 정렬 후");
//        for (Applicant applicant : applicants) {
//            System.out.println("지원언어: " + applicant.language +
//                    " 포지션: " + applicant.position +
//                    " 경력 구분: " + applicant.career +
//                    " 선호 음식: " + applicant.food +
//                    " 코딩테스트 점수: " + applicant.score);
//        }
        for(String temp:query){
            String[] querys = temp.replaceAll("and ","").split(" ");
            Language language = Language.findByValue(querys[0]);
            Position position = Position.findByValue(querys[1]);
            Career career = Career.findByValue(querys[2]);
            Food food = Food.findByValue(querys[3]);
            int score = Integer.parseInt(querys[4]);

            // 1. score 먼저 체크
            List<Applicant> filterList = applicants.stream()
                    .filter(applicant -> applicant.score >= score)
                    .collect(Collectors.toList());

//            System.out.println("기준 점수 이상 지원자 정보");
//            for (Applicant applicant : filterList) {
//                System.out.println("지원언어: " + applicant.language +
//                        " 포지션: " + applicant.position +
//                        " 경력 구분: " + applicant.career +
//                        " 선호 음식: " + applicant.food +
//                        " 코딩테스트 점수: " + applicant.score);
//            }

            List<Applicant> finalList = filterList.stream()
                    .filter(applicant -> applicant.language.equals(language) || language.equals(Language.NONE))
                    .filter(applicant -> applicant.position.equals(position) || position.equals(Position.NONE))
                    .filter(applicant -> applicant.career.equals(career) || career.equals(Career.NONE))
                    .filter(applicant -> applicant.food.equals(food) || food.equals(Food.NONE))
                    .collect(Collectors.toList());

            int count = (int) finalList.stream().count();
            answer.add(count);

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Applicant{
    public Language language;
    public Position position;
    public Career career;
    public Food food;
    public int score;

    public Applicant(Language language, Position position, Career career, Food food, int score) {
        this.language = language;
        this.position = position;
        this.career = career;
        this.food = food;
        this.score = score;
    }
}

enum Language{

    CPP("cpp"),
    JAVA("java"),
    PYTHON("python"),
    NONE("-");

    private final String language;
    Language(String language) {
        this.language = language;
    }

    public static Language findByValue(String value){
//        for(Language language:Language.values()){
//            if(language.language.equals(value)){
//                return language;
//            }
//        }
        //순차탐색 X
        return Arrays.stream(Language.values())
                .filter(language -> language.language.equals(value))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);

        //throw new IllegalArgumentException();
    }
}
enum Position{
    BACKEND("backend"),
    FRONTEND("frontend"),
    NONE("-");

    private final String position;

    Position(String position){
        this.position = position;
    }

    public static Position findByValue(String value){
//        for(Position position: Position.values()){
//            if(position.position.equals(value)){
//                return position;
//            }
//        }
        return Arrays.stream(Position.values())
                .filter(position -> position.position.equals(value))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        //throw new IllegalArgumentException();
    }
}
enum Career{
    JUNIOR("junior"),
    SENIOR("senior"),
    NONE("-");

    private final String career;

    Career(String career){
        this.career = career;
    }

    public static Career findByValue(String value) {
//        for (Career career : Career.values()) {
//            if(career.career.equals(value)) {
//                return career;
//            }
//        }
//        throw new IllegalArgumentException();
        return Arrays.stream(Career.values())
                .filter(career1 -> career1.career.equals(value))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
enum Food{
    CHICKEN("chicken"),
    PIZZA("pizza"),
    NONE("-");

    private final String food;

    Food(String food){
        this.food = food;
    }
    public static Food findByValue(String value){
//       for(Food food: Food.values()){
//           if(food.food.equals(value)){
//               return food;
//           }
//       }
//       throw new IllegalArgumentException();
        return Arrays.stream(Food.values())
                .filter(food -> food.food.equals(value))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}


