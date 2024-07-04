import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int start = 1;
        int end = max;
        int mid = 0;
        while (start < end) {
            mid = (start + end + 1) / 2;

            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (mid >= arr[i]) {
                    tmp += arr[i];
                } else {
                    tmp += mid;
                }
            }

            if (tmp > m) {
                end = mid - 1;
            } else if (tmp < m) {
                start = mid;
            } else {
                System.out.println(mid);
                return;
            }
        }

        System.out.println(start);
    }
}