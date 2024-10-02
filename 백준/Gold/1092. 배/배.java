import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Integer> crane, box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        crane = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane);
        Collections.sort(box);
        if (crane.get(n - 1) < box.get(m - 1)) {
            System.out.println(-1);
            return;
        }

        int left = 1;
        int right = m;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;

            if (checkInTime(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    static boolean checkInTime(int num) {
        int cnt = 0;
        int lstBox = -1;
        for (int i = 0; i < n; i++) {
            int craneW = crane.get(i);

            for (int j = 0; j < num && lstBox + 1 < m; j++) {
                if (craneW >= box.get(lstBox + 1)) {
                    cnt++;
                    lstBox++;
                }
            }
        }

        return cnt == m;
    }
}