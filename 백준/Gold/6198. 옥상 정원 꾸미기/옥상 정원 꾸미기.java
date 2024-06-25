import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> height = new Stack<>();
        for (int i = 0; i < n; i++) {
            height.push(Integer.parseInt(br.readLine()));
        }

        long answer = 0;
        Stack<Pair> stack = new Stack<>();
        while (!height.isEmpty()) {
            int tmp = height.pop();
            int sum = 0;

            while (!stack.isEmpty() && stack.peek().height < tmp) {
                sum += (stack.pop().benchmark + 1);
            }
            stack.push(new Pair(tmp, sum));

            answer += sum;
        }

        System.out.println(answer);
    }

    static class Pair {
        int height, benchmark;

        Pair(int height, int benchmark) {
            this.height = height;
            this.benchmark = benchmark;
        }
    }
}