import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Queue<Integer> nums = new LinkedList<>();
        Queue<Character> chars = new LinkedList<>();
        int idx = 0;
        while (idx < s.length()) {
            int start = idx;
            while (idx < s.length() && s.charAt(idx) != '+' && s.charAt(idx) != '-') {
                idx++;
            }

            nums.add(Integer.parseInt(s.substring(start, idx)));
            if (idx == s.length()) {
                break;
            }

            chars.add(s.charAt(idx));

            idx = idx + 1;
        }

        int ans = nums.poll();
        while (!chars.isEmpty()) {
            char c = chars.poll();

            if (c == '+') {
                ans += nums.poll();
            } else {
                int tmp = nums.poll();
                while (!chars.isEmpty() && chars.peek() == '+') {
                    chars.poll();
                    tmp += nums.poll();
                }

                ans -= tmp;
            }
        }

        System.out.println(ans);
    }
}