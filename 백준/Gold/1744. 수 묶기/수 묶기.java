import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int zeros = 0;
        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp > 0) {
                plus.add(tmp);
            } else if (tmp < 0) {
                minus.add(tmp);
            } else {
                zeros++;
            }
        }

        int ans = 0;
        Collections.sort(plus);
        if (plus.size() % 2 == 0) {
            for (int i = 0; i < plus.size(); i += 2) {
                ans += (plus.get(i) * plus.get(i + 1));

                if (plus.get(i) == 1) {
                    ans++;
                }
            }
        } else {
            for (int i = plus.size() - 1; i > 0; i -= 2) {
                ans += (plus.get(i) * plus.get(i - 1));

                if (plus.get(i - 1) == 1) {
                    ans++;
                }
            }

            ans += plus.get(0);
        }

        Collections.sort(minus);
        if (minus.size() % 2 == 0) {
            for (int i = 0; i < minus.size(); i += 2) {
                ans += (minus.get(i) * minus.get(i + 1));
            }
        } else {
            for (int i = 0; i < minus.size() - 1; i += 2) {
                ans += (minus.get(i) * minus.get(i + 1));
            }

            if (zeros == 0) {
                ans += minus.get(minus.size() - 1);
            }
        }

        System.out.println(ans);
    }
}