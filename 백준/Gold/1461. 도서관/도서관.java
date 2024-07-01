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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());

            if (t > 0) {
                plus.add(t);
            } else {
                minus.add(-t);
            }
        }

        Collections.sort(minus);
        Collections.sort(plus);
        int minusIdx = minus.size() - 1;
        int plusIdx = plus.size() - 1;
        int ans = 0;
        for (int i = minusIdx; i >= 0; i -= m) {
            ans += (minus.get(i) * 2);
        }
        for (int i = plusIdx; i >= 0; i -= m) {
            ans += (plus.get(i) * 2);
        }

        int minusMax = minusIdx < 0 ? 0 : minus.get(minusIdx);
        int plusMax = plusIdx < 0 ? 0 : plus.get(plusIdx);
        ans -= Math.max(minusMax, plusMax);

        System.out.println(ans);
    }
}