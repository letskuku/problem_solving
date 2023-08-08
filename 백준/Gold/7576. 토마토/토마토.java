import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];
        int[][] dist = new int[m][n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < n; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[j][i] = Integer.parseInt(tmp.nextToken());
            }
        }

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[j][i] == 1) {
                    q.add(new Pair(j, i));
                } else if (board[j][i] == 0) {
                    dist[j][i] = -1;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair pair = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = pair.x + dx[dir];
                int ny = pair.y + dy[dir];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (dist[nx][ny] >= 0) {
                    continue;
                }

                dist[nx][ny] = dist[pair.x][pair.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[j][i] == -1) {
                    System.out.print(-1);
                    return;
                }

                ans = Math.max(ans, dist[j][i]);
            }
        }

        System.out.print(ans);
    }

    public static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}