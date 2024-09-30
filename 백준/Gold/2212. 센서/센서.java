import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> sensors = new ArrayList<>(set);
        Collections.sort(sensors);

        List<Integer> len = new ArrayList<>();
        for (int i = 0; i < sensors.size() - 1; i++) {
            len.add(Math.abs(sensors.get(i) - sensors.get(i + 1)));
        }

        Collections.sort(len);
        int ans = 0;
        if (k - 1 < len.size()) {
            for (int i = 0; i < len.size() - (k - 1); i++) {
                ans += len.get(i);
            }
        }

        System.out.println(ans);
    }
}