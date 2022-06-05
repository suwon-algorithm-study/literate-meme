package yeonuk.baekjoon.에디터_1406;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) {
        try {
            Main2 main = new Main2();
            main.solve();
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }


    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        Editor editor = new Editor(stk.nextToken());


        stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            String command = stk.nextToken();

            if (command.equals("P")) {
                String character = stk.nextToken();
                editor.edit(command, character);
            } else {
                editor.edit(command);
            }
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(editor.getText());
        bw.flush();
        bw.close();
    }

    static class Editor {

        private String text;

        private int cursor;

        private final StringBuilder stringBuilder;

        public Editor(String text) {
            this.text = text;
            this.cursor = text.length();
            this.stringBuilder = new StringBuilder();
        }

        public String getText() {
            return text;
        }

        private void commandL() {
            if (cursor > 0) {
                cursor -= 1;
            }
        }

        private void commandD() {
            if (cursor < text.length()) {
                cursor += 1;
            }
        }

        private void commandB() {
            if (cursor > 0) {
                stringBuilder.setLength(0);
                text = stringBuilder.append(text, 0, cursor - 1)
                        .append(text, cursor, text.length())
                        .toString();
                cursor -= 1;
            }
        }

        private void commandP(String character) {
            stringBuilder.setLength(0);
            text = stringBuilder.append(text, 0, cursor)
                    .append(character)
                    .append(text, cursor, text.length())
                    .toString();
            cursor += 1;
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

        public void edit(String command, String character) {
            switch (command) {
                case "P":
                    commandP(character);
                    break;
                default:
                    throw new IllegalArgumentException("등록되지 않은 명령어 입니다 command=" + command);
            }
        }
    }
}
