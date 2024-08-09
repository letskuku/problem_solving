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
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int ans = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'W') {
                    continue;
                }

                int[][] visited = new int[n][m];
                int tmp = 0;
                Queue<Pair> q = new LinkedList<>();
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] == 'W') {
                        continue;
                    }

                    visited[x][y] = visited[i][j] + 1;
                    tmp = Math.max(visited[x][y], tmp);
                    q.add(new Pair(x, y));
                }
                visited[i][j] = -1;

                while (!q.isEmpty()) {
                    Pair p = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int x = p.x + dx[k];
                        int y = p.y + dy[k];

                        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] == 'W' || visited[x][y] != 0) {
                            continue;
                        }

                        visited[x][y] = visited[p.x][p.y] + 1;
                        tmp = Math.max(visited[x][y], tmp);
                        q.add(new Pair(x, y));
                    }
                }

                ans = Math.max(ans, tmp);
            }
        }

        System.out.println(ans);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}