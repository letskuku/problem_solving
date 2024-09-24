import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (n == 2) {
            int ans = Integer.MAX_VALUE;

            ans = Math.min(ans, cost[0][0] + cost[1][1]);
            ans = Math.min(ans, cost[0][0] + cost[1][2]);
            ans = Math.min(ans, cost[0][1] + cost[1][0]);
            ans = Math.min(ans, cost[0][1] + cost[1][2]);
            ans = Math.min(ans, cost[0][2] + cost[1][0]);
            ans = Math.min(ans, cost[0][2] + cost[1][1]);

            System.out.println(ans);
            return;
        }

        int[][] r = new int[n][3];
        int[][] g = new int[n][3];
        int[][] b = new int[n][3];
        r[2][0] = Math.min(cost[1][1], cost[1][2]) + cost[0][0] + cost[2][0];
        r[2][1] = cost[0][0] + cost[1][2] + cost[2][1];
        r[2][2] = cost[0][0] + cost[1][1] + cost[2][2];
        g[2][0] = cost[0][1] + cost[1][2] + cost[2][0];
        g[2][1] = Math.min(cost[1][0], cost[1][2]) + cost[0][1] + cost[2][1];
        g[2][2] = cost[0][1] + cost[1][0] + cost[2][2];
        b[2][0] = cost[0][2] + cost[1][1] + cost[2][0];
        b[2][1] = cost[0][2] + cost[1][0] + cost[2][1];
        b[2][2] = Math.min(cost[1][0], cost[1][1]) + cost[0][2] + cost[2][2];

        if (n == 3) {
            int ans = Integer.MAX_VALUE;

            ans = Math.min(ans, r[2][1]);
            ans = Math.min(ans, r[2][2]);
            ans = Math.min(ans, g[2][0]);
            ans = Math.min(ans, g[2][2]);
            ans = Math.min(ans, b[2][0]);
            ans = Math.min(ans, b[2][1]);

            System.out.println(ans);
            return;
        }

        for (int i = 3; i < n - 1; i++) {
            r[i][0] = Math.min(r[i - 1][1], r[i - 1][2]) + cost[i][0];
            r[i][1] = Math.min(r[i - 1][0], r[i - 1][2]) + cost[i][1];
            r[i][2] = Math.min(r[i - 1][0], r[i - 1][1]) + cost[i][2];
            g[i][0] = Math.min(g[i - 1][1], g[i - 1][2]) + cost[i][0];
            g[i][1] = Math.min(g[i - 1][0], g[i - 1][2]) + cost[i][1];
            g[i][2] = Math.min(g[i - 1][0], g[i - 1][1]) + cost[i][2];
            b[i][0] = Math.min(b[i - 1][1], b[i - 1][2]) + cost[i][0];
            b[i][1] = Math.min(b[i - 1][0], b[i - 1][2]) + cost[i][1];
            b[i][2] = Math.min(b[i - 1][0], b[i - 1][1]) + cost[i][2];
        }

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, Math.min(r[n - 2][0], r[n - 2][2]) + cost[n - 1][1]);
        ans = Math.min(ans, Math.min(r[n - 2][0], r[n - 2][1]) + cost[n - 1][2]);
        ans = Math.min(ans, Math.min(g[n - 2][1], g[n - 2][2]) + cost[n - 1][0]);
        ans = Math.min(ans, Math.min(g[n - 2][0], g[n - 2][1]) + cost[n - 1][2]);
        ans = Math.min(ans, Math.min(b[n - 2][1], b[n - 2][2]) + cost[n - 1][0]);
        ans = Math.min(ans, Math.min(b[n - 2][0], b[n - 2][2]) + cost[n - 1][1]);

        System.out.println(ans);
    }
}