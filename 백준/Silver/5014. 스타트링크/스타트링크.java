import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        if (s == g) {
            System.out.println(0);
            return;
        }
        
        int[] dx = {u, -d};
        int[] arr = new int[f + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 2; i++) {
                int nxt = cur + dx[i];

                if (nxt == s || nxt <= 0 || nxt > f || arr[nxt] > 0) {
                    continue;
                }
                if (nxt == g) {
                    System.out.println(arr[cur] + 1);
                    return;
                }

                arr[nxt] = arr[cur] + 1;
                q.add(nxt);
            }
        }

        System.out.println("use the stairs");
    }
}