package jian.baekjoon.에디터_1406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private Stack<Character> stackL;
    private Stack<Character> stackR;

    public Main(Stack<Character> stackL, Stack<Character> stackR) {
        this.stackL = stackL;
        this.stackR = stackR;
    }

    public static void main(String[] args) {
        Main main = new Main(new Stack<Character>(), new Stack<Character>());
        main.solve();
    }

    public void solve() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String inputStr = br.readLine();
            int m = Integer.parseInt(br.readLine());

            for (int i = 0; i < inputStr.length(); i++) {
                stackL.push(inputStr.charAt(i));
            }

            while (m-- > 0) {
                editor(br.readLine());
            }

            while (!stackL.isEmpty())
                stackR.push(stackL.pop());

            while (!stackR.isEmpty())
                bw.write(stackR.pop());

            bw.flush();

            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editor(String command) {

        switch (String.valueOf(command.charAt(0))) {
            case "L":
                if (stackL.isEmpty()) break;
                stackR.push(stackL.pop());
                break;

            case "D":
                if (stackR.isEmpty()) break;
                stackL.push(stackR.pop());

                break;

            case "B":
                if (stackL.isEmpty()) break;
                stackL.pop();
                break;

            case "P":
                StringTokenizer st = new StringTokenizer(command);

                st.nextToken();
                char addChar = st.nextToken().charAt(0);

                stackL.push(addChar);

                break;

            default:
                break;
        }
    }

}
