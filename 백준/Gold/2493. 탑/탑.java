import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().height > height) {
                    sb.append(stack.peek().idx + " ");
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            }

            stack.push(new Pair(height, i));
        }

        System.out.println(sb);
    }

    static class Pair {
        int height, idx;

        Pair(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }
}