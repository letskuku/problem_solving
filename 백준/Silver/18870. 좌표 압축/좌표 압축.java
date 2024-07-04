import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] origin = new int[n];
        int[] tmp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            tmp[i] = origin[i];
        }

        Arrays.sort(tmp);
        List<Integer> sorted = new ArrayList<>();
        sorted.add(tmp[0]);
        int prev = tmp[0];
        for (int i = 1; i < n; i++) {
            if (tmp[i] != prev) {
                sorted.add(tmp[i]);
                prev = tmp[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = sorted.size() - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (sorted.get(mid) > origin[i]) {
                    end = mid - 1;
                } else if (sorted.get(mid) < origin[i]) {
                    start = mid + 1;
                } else {
                    sb.append(mid + " ");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}