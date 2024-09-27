import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        func(s, t);

        System.out.println(ans);
    }

    static void func(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                ans = 1;
            }

            return;
        }

        if (t.charAt(t.length() - 1) == 'A') {
            func(s, t.substring(0, t.length() - 1));
        }

        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t.substring(1));
            func(s, sb.reverse().toString());
        }
    }
}