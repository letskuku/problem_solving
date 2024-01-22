import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] loss = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            loss[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(loss);
        long max = 0;
        if (n % 2 == 1) {
            max = loss[n - 1];
            for (int i = 0; i < n / 2; i++) {
                max = Math.max(max, loss[i] + loss[n - i - 2]);
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                max = Math.max(max, loss[i] + loss[n - i - 1]);
            }
        }

        System.out.println(max);
    }
}