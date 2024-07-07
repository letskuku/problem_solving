import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        List<Integer> sharks = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sharks.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(sharks);

        Stack<Integer> stack = new Stack<>();
        int eaten = 0;
        int idx = 0;
        long ans = t;
        while (eaten < k) {
            while (idx < sharks.size() && sharks.get(idx) < ans) {
                stack.push(sharks.get(idx));
                idx++;
            }

            if (!stack.isEmpty()) {
                ans += stack.pop();
            }

            eaten++;
        }

        System.out.println(ans);
    }
}