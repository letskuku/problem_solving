import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        boolean[] nums = new boolean[1000001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());

            nums[t] = true;
        }

        int x = Integer.parseInt(br.readLine());
        int range = x % 2 == 0 ? (x / 2) - 1 : x / 2;
        int ans = 0;
        for (int i = 1; i <= range; i++) {
            if (x - i > 1000000) {
                continue;
            }
            if (nums[i] && nums[x - i]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}