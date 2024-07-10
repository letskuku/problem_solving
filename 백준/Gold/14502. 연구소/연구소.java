import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, zeros = 0, ans = 0;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 0) {
                    zeros++;
                }
            }
        }

        func(0, 0, 0);

        System.out.println(ans);
    }

    static void func(int wall, int x, int y) {
        if (wall == 3) {
            bfs();
            return;
        }

        if (x < n) {
            for (int j = y; j < m; j++) {
                if (board[x][j] == 0) {
                    board[x][j] = 1;

                    if (j + 1 == m) {
                        func(wall + 1, x + 1, 0);
                    } else {
                        func(wall + 1, x, j + 1);
                    }

                    board[x][j] = 0;
                }
            }
        }

        for (int i = x + 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;

                    if (j + 1 == m) {
                        func(wall + 1, i + 1, 0);
                    } else {
                        func(wall + 1, i, j + 1);
                    }

                    board[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int tmp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2 && !visited[i][j]) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }

                while (!q.isEmpty()) {
                    Pair p = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int xx = p.x + dx[k];
                        int yy = p.y + dy[k];

                        if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
                            continue;
                        }

                        if (visited[xx][yy] || board[xx][yy] != 0) {
                            continue;
                        }

                        q.add(new Pair(xx, yy));
                        visited[xx][yy] = true;
                        tmp++;
                    }
                }
            }
        }

        ans = Math.max(ans, zeros - (3 + tmp));
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}