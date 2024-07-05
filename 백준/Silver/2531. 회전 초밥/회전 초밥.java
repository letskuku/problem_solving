import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] eaten = new int[d + 1];
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (eaten[arr[i]] == 0) {
                count++;
            }

            eaten[arr[i]]++;
        }

        int ans = eaten[c] == 0 ? count + 1 : count;
        for (int i = 1; i < n; i++) {
            int end = (i + k - 1) % n;
            if (eaten[arr[end]] == 0) {
                count++;
            }
            eaten[arr[end]]++;

            eaten[arr[i - 1]]--;
            if (eaten[arr[i - 1]] == 0) {
                count--;
            }

            if (ans <= count) {
                if (eaten[c] == 0) {
                    ans = count + 1;
                } else {
                    ans = count;
                }
            }
        }

        System.out.println(ans);
    }
}