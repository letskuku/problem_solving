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

        int n = Integer.parseInt(br.readLine());
        int maxH = 0;
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, board[i][j]);
            }
        }

        int maxArea = 0, curArea;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean[][] visited;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < maxH; i++) {
            visited = new boolean[n][n];
            curArea = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (board[j][k] <= i || visited[j][k]) {
                        continue;
                    }

                    curArea++;
                    q.add(new Pair(j,k));
                    visited[j][k] = true;
                    while (!q.isEmpty()) {
                        Pair p = q.poll();

                        for (int g = 0; g < 4; g++) {
                            int x = p.x + dx[g];
                            int y = p.y + dy[g];

                            if (x < 0 || x >= n || y < 0 || y >= n) {
                                continue;
                            }
                            if (board[x][y] <= i || visited[x][y]) {
                                continue;
                            }

                            q.add(new Pair(x, y));
                            visited[x][y] = true;
                        }
                    }
                }
            }

            maxArea = Math.max(maxArea, curArea);
        }

        System.out.println(maxArea);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}