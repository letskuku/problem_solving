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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int[][][] visited = new int[n][m][2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<Tuple> q = new LinkedList<>();
        visited[0][0][0] = 1;
        q.add(new Tuple(0, 0, false));
        while (!q.isEmpty()) {
            Tuple t = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                if (board[x][y] == '0') {
                    if (t.broken && visited[x][y][1] == 0) {
                        q.add(new Tuple(x, y, true));
                        visited[x][y][1] = visited[t.x][t.y][1] + 1;
                    } else if (!t.broken && visited[x][y][0] == 0) {
                        q.add(new Tuple(x, y, false));
                        visited[x][y][0] = visited[t.x][t.y][0] + 1;
                    }
                } else {
                    if (!t.broken && visited[x][y][1] == 0) {
                        q.add(new Tuple(x, y, true));
                        visited[x][y][1] = visited[t.x][t.y][0] + 1;
                    }
                }
            }
        }

        int notBroken = visited[n - 1][m - 1][0] == 0 ? 987654321 : visited[n - 1][m - 1][0];
        int broken = visited[n - 1][m - 1][1] == 0 ? 987654321 : visited[n - 1][m - 1][1];
        int ans = Math.min(notBroken, broken);

        if (ans == 987654321) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static class Tuple {
        int x, y;
        boolean broken;

        Tuple(int x, int y, boolean broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }
}