import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> cost = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int pre = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());

            cost.add(cur - pre);
            pre = cur;
        }

        Collections.sort(cost);
        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            ans += cost.get(i);
        }

        System.out.println(ans);
    }
}