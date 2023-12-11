import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] hamAndPpl = st.nextToken().toCharArray();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (hamAndPpl[i] == 'H') {
                for (int j = Math.max(0, i - k); j <= Math.min(n - 1, i + k); j++) {
                    if (hamAndPpl[j] == 'P') {
                        ans++;
                        hamAndPpl[j] = 'N';

                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}