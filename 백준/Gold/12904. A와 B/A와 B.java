import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());

        for (int i = t.length() - 1; i >= s.length(); i--) {
            char last = t.charAt(i);
            t = new StringBuilder(t.substring(0, i));

            if (last == 'B') {
                t.reverse();
            }
        }

        int ans = 0;
        if (s.equals(t.toString())) {
            ans = 1;
        }

        System.out.println(ans);
    }
}