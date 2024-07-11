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

        if (list.get(0) > 0) {
            System.out.println(list.get(0) + " " + list.get(1));
            return;
        } else if (list.get(n - 1) < 0) {
            System.out.println(list.get(n - 2) + " " + list.get(n - 1));
            return;
        }

        int prev = 2000000001;
        int end = n - 1;
        int[] ans = new int[2];
        for (int i = 0; i < n - 1; i++) {
            for (int j = end; j > i; j--) {
                int tmp = list.get(i) + list.get(j);

                if (tmp == 0) {
                    System.out.println(list.get(i) + " " + list.get(j));
                    return;
                } else if (tmp > 0) {
                    if (tmp < prev) {
                        prev = tmp;
                        ans[0] = list.get(i);
                        ans[1] = list.get(j);
                    }
                } else {
                    tmp = Math.abs(tmp);

                    if (tmp < prev) {
                        prev = tmp;
                        ans[0] = list.get(i);
                        ans[1] = list.get(j);
                    }

                    end = j;
                    break;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}