import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        int[] visited = new int[101];
        for (int i = 0; i < 101; i++) {
            board[i] = -1;
            visited[i] = -1;
        }

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());

            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 0;
        while (!q.isEmpty()) {
            int loc = q.poll();

            for (int i = 1; i <= 6; i++) {
                int tmp = loc + i;

                if (tmp <= 100 && visited[tmp] < 0) {
                    visited[tmp] = visited[loc] + 1;

                    if (board[tmp] > 0) {
                        if (visited[board[tmp]] < 0) {
                            visited[board[tmp]] = visited[loc] + 1;
                            q.add(board[tmp]);
                        }
                    } else {
                        q.add(tmp);
                    }
                }
            }
        }

        System.out.println(visited[100]);
    }
}