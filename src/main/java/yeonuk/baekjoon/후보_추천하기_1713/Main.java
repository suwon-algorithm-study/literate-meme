package yeonuk.baekjoon.후보_추천하기_1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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
        Frame frame = new Frame(input.getN());
        CandidateBoard board = new CandidateBoard();

        for (Integer number : input.getValues()) {
            if (frame.isFull() || frame.exist(number)) {
                if (frame.isNew(number)) {
                    frame.sort();
                    Candidate candidate = frame.remove();
                    board.claer(candidate.getNumber());
                }

                board.vote(number);
                Candidate candidate = board.getCandidate(number);
                frame.add(candidate);
            } else {
                board.vote(number);
                Candidate candidate = board.getCandidate(number);
                frame.push(candidate);
            }
        }

        System.out.println(frame.getFrameNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    static class Frame {

        private int frameCount;

        private List<Candidate> frames;

        public Frame(int frameCount) {
            this.frameCount = frameCount;
            this.frames = new ArrayList<>();
        }

        public void push(Candidate candidate) {
            frames.add(candidate);
        }

        public boolean isFull() {
            return frames.size() == frameCount;
        }

        public void sort() {
            Collections.sort(frames);
        }


        public boolean exist(Integer number) {
            List<Integer> numbers = frames.stream()
                    .map(Candidate::getNumber)
                    .collect(Collectors.toList());

            return numbers.contains(number);
        }
        public boolean isNew(Integer number) {
            return !exist(number);
        }

        public void add(Candidate candidate) {
            frames.removeIf(c -> c.getNumber() == candidate.getNumber());
            frames.add(candidate);
        }

        public Candidate remove() {
            Candidate candidate = frames.get(0);
            frames.remove(candidate);
            return candidate;
        }

        public List<Integer> getFrameNumbers() {
            return frames.stream()
                    .map(Candidate::getNumber)
                    .sorted()
                    .collect(Collectors.toList());
        }
    }

    static class CandidateBoard {

        private Map<Integer, Candidate> candidates;

        public CandidateBoard() {
            this.candidates = new HashMap<>();
            for (int i = 1; i <= 100; i++) {
                Candidate candidate = new Candidate(i);
                candidates.put(i, candidate);
            }
        }

        public Candidate getCandidate(int number) {
            return this.candidates.get(number);
        }

        public void vote(int number) {
            Candidate candidate = candidates.get(number);
            candidate.vote();
            candidates.put(number, candidate);
        }

        public void claer(int number) {
            candidates.put(number, new Candidate(number));
        }
    }

    static class Candidate implements Comparable<Candidate> {

        private final int number;

        private int voteCount;

        public Candidate(int number) {
            this.number = number;
            this.voteCount = 0;
        }

        public void vote() {
            this.voteCount += 1;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public int compareTo(Candidate o) {
            return this.voteCount >= o.voteCount ? 1 : -1;
        }
    }

    static class Input {

        private int n;
        private int m;
        private List<Integer> values;

        public Input() {
            this.values = new ArrayList<>();
        }

        public void init() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(stk.nextToken());

            stk = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(stk.nextToken());

            stk = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                values.add(Integer.valueOf(stk.nextToken()));
            }

            br.close();
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }

        public List<Integer> getValues() {
            return values;
        }
    }
}


/*
3
9
2 1 4 3 5 6 2 7 2

2
2 1
2 1 4
3 1 4
3 5 4
3 5 6
2 5 6
2 7 6



1 2 3 4 5 6 7 8 9
0 1 0 0 0 1 1 0 0
*/