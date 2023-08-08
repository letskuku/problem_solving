import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];
        boolean[][] visit = new boolean[m][n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < n; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[j][i] = Integer.parseInt(tmp.nextToken());
            }
        }

        int num = 0; //그림 개수
        int mx = 0; //그림 최대 넓이
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[j][i] || board[j][i] == 0) {
                    continue;
                }

                num++;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(j, i));
                visit[j][i] = true;
                int area = 0;
                while (!q.isEmpty()) {
                    Pair pair = q.poll();
                    area++;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = pair.x + dx[dir];
                        int ny = pair.y + dy[dir];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            continue;
                        }

                        if (visit[nx][ny] || board[nx][ny] == 0) {
                            continue;
                        }

                        visit[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }

                mx = Math.max(area, mx);
            }
        }

        System.out.println(num);
        System.out.println(mx);
    }

    public static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
