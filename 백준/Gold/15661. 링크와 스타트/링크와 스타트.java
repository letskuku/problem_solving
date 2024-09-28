import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] isUsed;
    static int[][] s;
    static int n;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        isUsed = new int[n];

        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n / 2; i++) {
            func(i, 0, -1);
        }

        if (n % 2 == 0) {
            isUsed[0] = 1;
            func(n / 2, 1, 0);
        } else {
            func(n / 2, 0, -1);
        }

        System.out.println(ans);
    }

    static void func(int start, int num, int lstIdx) {
        if (start == num) {
            int[] sum = new int[2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (isUsed[j] == i) {
                        for (int k = j + 1; k < n; k++) {
                            if (isUsed[k] == i) {
                                sum[i] += s[j][k];
                                sum[i] += s[k][j];
                            }
                        }
                    }
                }
            }
            
            ans = Math.min(ans, Math.abs(sum[0] - sum[1]));
            return;
        }

        for (int i = lstIdx + 1; i < n; i++) {
            isUsed[i] = 1;

            func(start, num + 1, i);

            isUsed[i] = 0;
        }
    }
}