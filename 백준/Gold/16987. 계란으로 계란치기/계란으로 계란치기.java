import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, cnt = 0;
    static int[][] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        eggs = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        func(0);
        System.out.println(cnt);
    }

    static void func(int cur) {
        if (cur == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i][0] <= 0) {
                    sum++;
                }
            }

            cnt = Math.max(cnt, sum);
            return;
        }

        if (eggs[cur][0] <= 0) {
            func(cur + 1);
            return;
        }

        boolean recursive = false;
        for (int i = 0; i <= n - 1; i++) {
            if (eggs[i][0] <= 0 || cur == i) {
                continue;
            }

            recursive = true;
            eggs[cur][0] -= eggs[i][1];
            eggs[i][0] -= eggs[cur][1];
            func(cur + 1);
            eggs[cur][0] += eggs[i][1];
            eggs[i][0] += eggs[cur][1];
        }

        if (!recursive) {
            func(cur + 1);
        }
    }
}