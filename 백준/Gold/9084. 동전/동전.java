import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[][] d = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i - coins[j] >= 0) {
                        for (int k = i; k > 0; k -= coins[j]) {
                            d[i][j] += d[k][j - 1];
                        }

                        if (i % coins[j] == 0) {
                            d[i][j]++;
                        }
                    } else {
                        d[i][j] = d[i][j - 1];
                    }
                }
            }

            System.out.println(d[m][n]);
        }
    }
}