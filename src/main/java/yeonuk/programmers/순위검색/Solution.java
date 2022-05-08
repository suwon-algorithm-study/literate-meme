package yeonuk.programmers.순위검색;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};


        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        Solution solution = new Solution();
        int[] answer = solution.solution(info, query);
        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(String[] infoArray, String[] queryArray) {
        List<Applicant> applicants = new ArrayList<>();
        for (String infoString : infoArray) {
            String[] info = infoString.split(" ");
            Language language = Language.findByCode(info[0]);
            JobGroup jobGroup = JobGroup.findByCode(info[1]);
            Career carrer = Career.findByCode(info[2]);
            SoulFood soulFood = SoulFood.findByCode(info[3]);
            int score = Integer.parseInt(info[4]);

            Applicant applicant = new Applicant(language, jobGroup, carrer, soulFood, score);
            applicants.add(applicant);
        }
        applicants.sort((o1, o2) -> o1.score >= o2.score ? 1 : -1);

        List<Long> answer = new ArrayList<>();
        for (String query : queryArray) {
            String[] queryInfo = query.replaceAll("and ", "")
                    .split(" ");

            Language language = Language.findByCode(queryInfo[0]);
            JobGroup jobGroup = JobGroup.findByCode(queryInfo[1]);
            Career carrer = Career.findByCode(queryInfo[2]);
            SoulFood soulFood = SoulFood.findByCode(queryInfo[3]);
            int score = Integer.parseInt(queryInfo[4]);

            List<Applicant> scoreFilteredApplicant = new ArrayList<>();
            for (int i = 0; i < applicants.size(); i++) {
                Applicant applicant = applicants.get(i);
                if (applicant.getScore() >= score) {
                    scoreFilteredApplicant.addAll(applicants.subList(i, applicants.size()));
                    break;
                }
            }

            long count = scoreFilteredApplicant.stream()
                    .filter(applicant -> applicant.getLanguage() == language || language == Language.NONE)
                    .filter(applicant -> applicant.getJobGroup() == jobGroup || jobGroup == JobGroup.NONE)
                    .filter(applicant -> applicant.getCareer() == carrer || carrer == Career.NONE)
                    .filter(applicant -> applicant.getSoulFood() == soulFood || soulFood == SoulFood.NONE)
                    .count();
            answer.add(count);
        }

        return answer.stream()
                .mapToInt(Long::intValue)
                .toArray();
    }

    static class Applicant {

        private final Language language;

        private final JobGroup jobGroup;

        private final Career career;

        private final SoulFood soulFood;

        private final int score;


        public Applicant(Language language, JobGroup jobGroup, Career career, SoulFood soulFood, int score) {
            this.language = language;
            this.jobGroup = jobGroup;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }

        public Language getLanguage() {
            return language;
        }

        public JobGroup getJobGroup() {
            return jobGroup;
        }

        public Career getCareer() {
            return career;
        }

        public SoulFood getSoulFood() {
            return soulFood;
        }

        public int getScore() {
            return score;
        }
    }

    enum Language {
        JAVA("java"),
        PYTHON("python"),
        CPP("cpp"),
        NONE("-"),
        ;

        private final String code;

        Language(String code) {
            this.code = code;
        }

        public static Language findByCode(String code) {
            return Arrays.stream(values())
                    .filter(language -> language.code.equals(code))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    enum JobGroup {
        BACKEND("backend"),
        FRONTEND("frontend"),
        NONE("-"),
        ;

        private final String code;

        JobGroup(String code) {
            this.code = code;
        }

        public static JobGroup findByCode(String code) {
            return Arrays.stream(values())
                    .filter(jopGroup -> jopGroup.code.equals(code))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    enum Career {
        JUNIOR("junior"),
        SENIOR("senior"),
        NONE("-"),
        ;

        private final String code;

        Career(String code) {
            this.code = code;
        }

        public static Career findByCode(String code) {
            return Arrays.stream(values())
                    .filter(career -> career.code.equals(code))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    enum SoulFood {
        CHICKEN("chicken"),
        PIZZA("pizza"),
        NONE("-"),
        ;

        private final String code;

        SoulFood(String code) {
            this.code = code;
        }

        public static SoulFood findByCode(String code) {
            return Arrays.stream(values())
                    .filter(soulFood -> soulFood.code.equals(code))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}

