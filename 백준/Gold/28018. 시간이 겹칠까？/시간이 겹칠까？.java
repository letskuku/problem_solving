import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] time = new int[1000002];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            time[Integer.parseInt(st.nextToken())]++;
            time[Integer.parseInt(st.nextToken()) + 1]--;
        }

        int[] seat = new int[1000001];
        for (int i = 1; i <= 1000000; i++) {
            seat[i] = seat[i - 1] + time[i];
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            sb.append(seat[Integer.parseInt(st.nextToken())] + "\n");
        }

        System.out.println(sb);
    }
}