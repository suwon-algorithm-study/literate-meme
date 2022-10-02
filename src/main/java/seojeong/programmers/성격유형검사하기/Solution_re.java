package seojeong.programmers.성격유형검사하기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_re {
    public static void main(String[] args) {
        Solution_re solution_re = new Solution_re();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        solution_re.solution(survey,choices);
    }
    public String solution(String[] survey, int[] choices){
        String answer = "";

        // User에 배열 전체를 넣어야할지, 아니면 값 하나씩 넣아햘지 모르겠음?
        // 배열로 다 넘기면 기존코드 그냥 함수화한 느낌.,,
        User user = new User("AN",5);
        user.calTotalCount("AN",5);

        return answer;
    }

    enum Choice{
        VERY_DISAGREE(1,3),
        DISAGREE(2,2),
        LITTLE_DISAGREE(3,1),
        UNKNOWN(4,0),
        LITTLE_AGREE(5,1),
        AGREE(6,2),
        VERY_AGREE(7,3);

        private final int idx;
        private final int score;

        Choice(int idx,int score){
            this.idx = idx;
            this.score = score;
        }
        public static int findByidx(int idx){
            return Arrays.stream(values())
                    .filter(choice -> choice.idx == idx)
                    .findFirst().get().score;

        }
    }
    enum CharacterCategory{
        R("R"),
        T("T"),
        C("C"),
        F("F"),
        J("J"),
        M("M"),
        A("A"),
        N("N");

        private final String character;
        CharacterCategory(String character){
            this.character = character;
        }
        public static String findByValue(String category){
            return Arrays.stream(values())
                    .filter(character -> character.character.equals(category))
                    .findFirst().get().character;

        }
    }

    class User{
        // User가 응답한 성격유형의 검사를 여기다가

        Map<String, Integer> total = new HashMap<>();

        // 서비스 로직 여기다가 -> Survey, choice 돌면서
        // 문항 지표
        private final String category;
        private final int userChoice;

        User(String category,int userChoice){
            this.category = category;
            this.userChoice = userChoice;
        }
        public int getScore(String cate){
            return total.get(cate);
        }

        public void calTotalCount(String category, int userChoice){
            String[] temp = category.split("");
            String cate1 = CharacterCategory.findByValue(temp[0]);
            String cate2 = CharacterCategory.findByValue(temp[1]);

            int score = Choice.findByidx(userChoice);

            if(userChoice < 3){
                int before = getScore(cate1);
                total.put(cate1,before+score);
            }else if(userChoice > 3) {
                int before = getScore(cate2);
                total.put(cate2, before + score);
            }else{
                // 모르겠음 선택했을 때 어케 처리?

            }
        }
    }
}
