import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<' || s.charAt(i) == '>' || s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (i - idx > 0) {
                    sb.append(s.substring(idx, i) + " ");
                }

                sb.append(s.charAt(i) + " ");

                idx = i + 1;
            } else if (s.charAt(i) == '&' || s.charAt(i) == '|') {
                if (i - idx > 0) {
                    sb.append(s.substring(idx, i) + " ");
                }

                sb.append(s.substring(i, i + 2) + " ");

                idx = i + 2;
                i++;
            } else if (s.charAt(i) == ' ') {
                if (i - idx > 0) {
                    sb.append(s.substring(idx, i) + " ");
                }

                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }

                if (i < s.length()) {
                    idx = i;
                    i--;
                }
            } else if (i == s.length() - 1) {
                sb.append(s.substring(idx) + " ");
            }
        }

        System.out.println(sb);
    }
}