import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int tmp, lastPush = 0;
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(br.readLine());

            if (tmp > lastPush) {
                for (int j = lastPush + 1; j < tmp; j++) {
                    stack.push(j);
                    sb.append("+ \n");
                }

                sb.append("+ \n");
                sb.append("- \n");
                lastPush = tmp;
            } else {
                while (!stack.isEmpty() && stack.peek() != tmp) {
                    stack.pop();
                    sb.append("- \n");
                }

                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else {
                    stack.pop();
                    sb.append("- \n");
                }
            }
        }

        System.out.println(sb);
    }
}