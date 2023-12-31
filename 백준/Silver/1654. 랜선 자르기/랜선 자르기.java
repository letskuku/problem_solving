import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lans = new int[k];
        int maxLen = 0;
        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());

            if (maxLen < lans[i]) {
                maxLen = lans[i];
            }
        }

        long ans = 0;
        long left = 1;
        long right = maxLen;
        long mid;
        while (left <= right) {
            mid = (left + right) / 2;

            int tmp = 0;
            for (int i = 0; i < k; i++) {
                tmp += lans[i] / mid;
            }

            if ((tmp >= n) && (mid > ans)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}