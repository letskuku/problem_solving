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

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> s = new ArrayList<>();
            List<Integer> nums = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                s.add(Integer.parseInt(st.nextToken()));
                nums.add(j);
            }

            StringBuilder sb = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                int tmp = s.get(j);

                if (tmp + 1 > nums.size()) {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                sb.insert(0, nums.get(tmp) + " ");
                nums.remove(tmp);
            }

            System.out.println(sb);
        }
    }
}