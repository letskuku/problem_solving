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

        int t = Integer.parseInt(br.readLine());
        int l, firX, firY, secX, secY;
        int[] dx = {-2, -1, -2, -1, 1, 2, 1, 2};
        int[] dy = {1, 2, -1, -2, 2, 1, -2, -1};
        boolean[][] visited;
        int[][] board;
        Queue<Pair> q;
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            firX = Integer.parseInt(st.nextToken());
            firY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            secX = Integer.parseInt(st.nextToken());
            secY = Integer.parseInt(st.nextToken());

            visited = new boolean[l][l];
            board = new int[l][l];
            q = new LinkedList<>();
            visited[firX][firY] = true;
            q.add(new Pair(firX, firY));
            while (!q.isEmpty()) {
                Pair p = q.poll();

                for (int j = 0; j < 8; j++) {
                    int x = p.x + dx[j];
                    int y = p.y + dy[j];

                    if (x < 0 || x >= l || y < 0 || y >= l || visited[x][y]) {
                        continue;
                    }

                    visited[x][y] = true;
                    board[x][y] = board[p.x][p.y] + 1;
                    q.add(new Pair(x, y));
                }
            }

            System.out.println(board[secX][secY]);
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}