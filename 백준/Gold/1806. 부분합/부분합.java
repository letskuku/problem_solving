import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int start = 0, end = 0;
        int ans = 100001;
        while (end < n) {
            while (sum < s && end < n) {
                sum += nums[end];
                end++;
            }

            while (sum >= s && start <= end) {
                ans = Math.min(ans, (end - start));

                sum -= nums[start];
                start++;
            }
        }

        ans = ans == 100001? 0 : ans;
        System.out.println(ans);
    }
}