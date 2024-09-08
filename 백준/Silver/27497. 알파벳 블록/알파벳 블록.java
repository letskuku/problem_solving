import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Stack<String> buttons = new Stack<>();
        Deque<String> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String button = st.nextToken();

            if (button.equals("1")) {
                ans.offerLast(st.nextToken());
                buttons.push(button);
            } else if (button.equals("2")) {
                ans.offerFirst(st.nextToken());
                buttons.push(button);
            } else {
                if (!ans.isEmpty()) {
                    String lst = buttons.pop();

                    if (lst.equals("1")) {
                        ans.removeLast();
                    } else {
                        ans.removeFirst();
                    }
                }
            }
        }
        
        if (ans.isEmpty()) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            while (!ans.isEmpty()) {
                sb.append(ans.remove());
            }

            System.out.println(sb);
        }
    }
}