import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];
        int[][] dist = new int[m][n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[j][i] = Integer.parseInt(tmp[j]);
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            Pair pair = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = pair.x + dx[dir];
                int ny = pair.y + dy[dir];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (board[nx][ny] == 0 || dist[nx][ny] > 0) {
                    continue;
                }

                dist[nx][ny] = dist[pair.x][pair.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }

        System.out.print(dist[m - 1][n - 1]);
    }

    public static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}