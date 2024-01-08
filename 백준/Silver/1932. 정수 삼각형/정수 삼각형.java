import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = 0;
            }
        }

        sum[0][0] = triangle[0][0];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                sum[i + 1][j] = Math.max(sum[i + 1][j], sum[i][j] + triangle[i + 1][j]);
                sum[i + 1][j + 1] = Math.max(sum[i + 1][j + 1], sum[i][j] + triangle[i + 1][j + 1]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, sum[n - 1][i]);
        }

        System.out.println(ans);
    }
}