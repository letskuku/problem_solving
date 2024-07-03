import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] strength = new int[n + 1];
        int[] enjoy = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            strength[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            enjoy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[101][n + 1];
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - strength[j] > 0) {
                    d[i][j] = Math.max(d[i][j - 1], d[i - strength[j]][j - 1] + enjoy[j]);
                } else {
                    d[i][j] = d[i][j - 1];
                }
            }
        }

        System.out.println(d[100][n]);
    }
}