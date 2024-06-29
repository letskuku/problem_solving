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

        st = new StringTokenizer(br.readLine());
        int hX = Integer.parseInt(st.nextToken());
        int hY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int eX = Integer.parseInt(st.nextToken());
        int eY = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][][] visited = new int[n + 1][m + 1][2];
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(hX, hY, false));
        while (!q.isEmpty()) {
            Tuple t = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];

                if ((x == hX && y == hY) || x < 1 || x > n || y < 1 || y > m) {
                    continue;
                }

                if (board[x][y] == 0) {
                    if (t.usedMagic && (visited[x][y][1] == 0)) {
                        q.add(new Tuple(x, y, true));
                        visited[x][y][1] = visited[t.x][t.y][1] + 1;
                    } else if (!t.usedMagic && (visited[x][y][0] == 0)) {
                        q.add(new Tuple(x, y, false));
                        visited[x][y][0] = visited[t.x][t.y][0] + 1;
                    }
                } else {
                    if (!t.usedMagic && (visited[x][y][1] == 0)) {
                        q.add(new Tuple(x, y, true));
                        visited[x][y][1] = visited[t.x][t.y][0] + 1;
                    }
                }
            }
        }

        int yesMagic = visited[eX][eY][1] == 0 ? 987654321 : visited[eX][eY][1];
        int noMagic = visited[eX][eY][0] == 0 ? 987654321 : visited[eX][eY][0];
        int ans = Math.min(yesMagic, noMagic);

        if (ans == 987654321) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static class Tuple {
        int x, y;
        boolean usedMagic;

        Tuple(int x, int y, boolean usedMagic) {
            this.x = x;
            this.y = y;
            this.usedMagic = usedMagic;
        }
    }
}