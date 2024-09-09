import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        int start = 0;
        int end = max;
        while (start < end) {
            int mid = (start + end) / 2;

            if (func(mid) <= m) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }

    static int func(int mid) {
        int cnt = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }

            if (max - min > mid) {
                cnt++;
                i--;

                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
        }

        return cnt;
    }
}