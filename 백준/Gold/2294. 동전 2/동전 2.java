import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = 10001;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins.get(j)) {
                    dp[i] = Math.min(dp[i], dp[i - coins.get(j)] + 1);
                }
            }
        }

        if (dp[k] < 10001) {
            System.out.println(dp[k]);
        } else {
            System.out.println(-1);
        }
    }
}