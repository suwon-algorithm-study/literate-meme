package yeonuk.baekjoon.상금헌터_15953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Input input = new Input();
            input.init();

            Main main = new Main();
            main.solve(input);
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }


    public void solve(Input input) {
        Festival firstFestival = initFirstReward();
        Festival secondFestival = initSecondReward();

        for (Rank rank : input.getRanks()) {
            long totalReward = firstFestival.getReward(rank.getA()) + secondFestival.getReward(rank.getB());

            System.out.println(totalReward);
        }
    }

    private Festival initFirstReward() {
        Festival festival = new Festival();
        festival.putReward(1, 5_000_000);
        festival.putReward(2, 3_000_000);
        festival.putReward(3, 2_000_000);
        festival.putReward(4, 500_000);
        festival.putReward(5, 300_000);
        festival.putReward(6, 100_000);

        return festival;
    }

    private Festival initSecondReward() {
        Festival festival = new Festival();
        festival.putReward(1, 5_120_000);
        festival.putReward(2, 2_560_000);
        festival.putReward(4, 1_280_000);
        festival.putReward(8, 640_000);
        festival.putReward(16, 320_000);

        return festival;
    }

    static class Festival {

        private Map<Integer, Long> rewards;

        private int total;

        public Festival() {
            rewards = new HashMap<>();
            total = 0;
        }

        public void putReward(int count, long reward) {
            for (int i = 0; i < count; i++) {
                total += 1;
                rewards.put(total, reward);
            }
        }

        public Long getReward(int rank) {
            return rewards.getOrDefault(rank, 0L);
        }
    }

    static class Input {

        private int n;
        private List<Rank> ranks;

        public Input() {
            this.ranks = new ArrayList<>();
        }

        public void init() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(stk.nextToken());

            for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                Rank rank = new Rank(a, b);
                ranks.add(rank);
            }

            br.close();
        }

        public int getN() {
            return n;
        }


        public List<Rank> getRanks() {
            return ranks;
        }
    }

    static class Rank {

        private final int a;

        private final int b;

        public Rank(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
