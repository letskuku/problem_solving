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

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int prev = 2000000001;
        int start = 0;
        int end = n - 1;
        int[] ans = new int[2];
        while (start < end) {
            int tmp = list.get(start) + list.get(end);

            if (tmp == 0) {
                System.out.println(list.get(start) + " " + list.get(end));
                return;
            } else if (tmp > 0) {
                if (tmp < prev) {
                    prev = tmp;
                    ans[0] = list.get(start);
                    ans[1] = list.get(end);
                }
                
                end--;
            } else {
                tmp = Math.abs(tmp);

                if (tmp < prev) {
                    prev = tmp;
                    ans[0] = list.get(start);
                    ans[1] = list.get(end);
                }

                start++;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}