import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0];
        int left = 0, right = 1;
        while (left < n && right < n) {
            int tmp = arr[right] - arr[left];
            
            if (tmp < m) {
                right++;
            } else if (tmp == m) {
                System.out.println(m);
                return;
            } else {
                ans = Math.min(ans, tmp);
                left++;
            }
        }

        System.out.println(ans);
    }
}