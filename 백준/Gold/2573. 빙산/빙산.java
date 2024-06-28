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
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int sum, years = 0;
        Queue<Pair> q = new LinkedList<>();
        Queue<Tuple> q2 = new LinkedList<>();
        boolean[][] visited;
        while (true) {
            years++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] > 0) {
                        int tmp = 0;
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];

                            if (x < 0 || x >= n || y < 0 || y >= m) {
                                continue;
                            }
                            if (board[x][y] == 0) {
                                tmp++;
                            }
                        }

                        q2.add(new Tuple(i, j, Math.max(0, board[i][j] - tmp)));
                    }
                }
            }
            while (!q2.isEmpty()) {
                Tuple t = q2.poll();
                board[t.x][t.y] = t.newH;
            }

            sum = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0 || visited[i][j]) {
                        continue;
                    }

                    sum++;
                    visited[i][j] = true;
                    q.add(new Pair(i, j));
                    while (!q.isEmpty()) {
                        Pair p = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int x = p.x + dx[k];
                            int y = p.y + dy[k];

                            if (x < 0 || x >= n || y < 0 || y >= m) {
                                continue;
                            }
                            if (board[x][y] == 0 || visited[x][y]) {
                                continue;
                            }

                            visited[x][y] = true;
                            q.add(new Pair(x, y));
                        }
                    }
                }
            }

            if (sum == 0) {
                System.out.println(0);
                return;
            } else if (sum > 1) {
                System.out.println(years);
                return;
            }
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class Tuple {
        int x, y, newH;
        
        Tuple(int x, int y, int newH) {
            this.x = x;
            this.y = y;
            this.newH = newH;
        }
    }
}