import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();

            Stack<Character> ans = new Stack<>();
            Stack<Character> tmp = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '<') {
                    if (!ans.isEmpty()) {
                        tmp.push(ans.pop());
                    }
                } else if (c == '>') {
                    if (!tmp.isEmpty()) {
                        ans.push(tmp.pop());
                    }
                } else if (c == '-') {
                    if (!ans.isEmpty()) {
                        ans.pop();
                    }
                } else {
                    ans.push(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Character c : ans) {
                sb.append(c);
            }
            while (!tmp.isEmpty()) {
                sb.append(tmp.pop());
            }
            System.out.println(sb);
        }
    }
}