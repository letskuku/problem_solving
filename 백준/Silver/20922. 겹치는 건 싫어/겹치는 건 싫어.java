import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] visited = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0, start = 0, end = 0;
        while (start < n && end < n) {
            if (visited[arr[end]] < k) {
                visited[arr[end]]++;
                end++;
            } else if (visited[arr[end]] == k) {
                ans = Math.max(ans, end - start);

                while (start < n && arr[start] != arr[end]) {
                    visited[arr[start]]--;
                    start++;
                }
                start++;
                end++;
            }

            if (end == n) {
                ans = Math.max(ans, (end - start));
            }
        }

        System.out.println(ans);
    }
}