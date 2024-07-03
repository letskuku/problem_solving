import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        pairs.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            } else {
                return o1.x - o2.x;
            }
        });

        int ans = 0;
        int start = pairs.get(0).x;
        int end = pairs.get(0).y;
        for (int i = 1; i < n; i++) {
            Pair p = pairs.get(i);

            if (p.x <= end) {
                if (p.y > end) {
                    end = p.y;
                }
            } else {
                ans += (end - start);

                start = p.x;
                end = p.y;
            }
        }

        ans += (end - start);

        System.out.println(ans);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}