package yeonuk.baekjoon.에디터_1406;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.solve();
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }


    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        Editor editor = new Editor(stk.nextToken());


        stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            String command = stk.nextToken();

            if (command.equals("P")) {
                char character = stk.nextToken().charAt(0);
                editor.edit(command, character);
            } else {
                editor.edit(command);
            }
        }

        br.close();

        for (Character character : editor.getCharacters()) {
            bw.write(character);
        }
        bw.flush();
        bw.close();
    }

    static class Editor {

        private final List<Character> characters;

        private final ListIterator<Character> iterator;

        public Editor(String text) {
            this.characters = new LinkedList<>();
            for (int i = 0; i < text.length(); i++) {
                characters.add(text.charAt(i));
            }

            ListIterator<Character> iterator = characters.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
            this.iterator = iterator;
        }

        private void commandL() {
            if (iterator.hasPrevious()) {
                iterator.previous();
            }
        }

        private void commandD() {
            if (iterator.hasNext()) {
                iterator.next();
            }
        }

        private void commandB() {
            if (iterator.hasPrevious()) {
                iterator.previous();
                iterator.remove();
            }
        }

        private void commandP(char character) {
            iterator.add(character);
        }

        public void edit(String command) {
            switch (command) {
                case "L":
                    commandL();
                    break;
                case "D":
                    commandD();
                    break;
                case "B":
                    commandB();
                    break;
                default:
                    throw new IllegalArgumentException("등록되지 않은 명령어 입니다 command=" + command);
            }
        }

        public void edit(String command, char character) {
            switch (command) {
                case "P":
                    commandP(character);
                    break;
                default:
                    throw new IllegalArgumentException("등록되지 않은 명령어 입니다 command=" + command);
            }
        }

        public List<Character> getCharacters() {
            return characters;
        }
    }
}
