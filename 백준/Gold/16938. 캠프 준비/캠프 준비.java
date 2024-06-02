import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, l, r, x, ans;
    static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        level = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(level);

        ans = 0;
        func(0, 0, -1, 0);

        System.out.println(ans);
    }

    static void func(int size, int firLv, int lstIdx, int sum) {
        if (size == n || sum == r) {
            return;
        }

        for (int i = lstIdx + 1; i < n; i++) {
            if (size != 0) {
                int tmpSum = sum + level[i];
                if (tmpSum <= r) {
                    if (tmpSum >= l) {
                        if (level[i] - firLv >= x) {
                            ans++;
                        }
                    }

                    func(size + 1, firLv, i, tmpSum);
                } else {
                    return;
                }
            } else {
                if (level[i] <= r) {
                    func(size + 1, level[i], i, sum + level[i]);
                }
            }
        }
    }
}