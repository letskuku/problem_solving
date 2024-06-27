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
        int w, h, startX = 0, startY = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        char[][] board;
        int[][] fire;
        int[][] sang;
        boolean[][] visited;
        Queue<Pair> q;
        boolean isPossible;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new char[w][h];
            visited = new boolean[w][h];
            q = new LinkedList<>();
            for (int j = 0; j < h; j++) {
                String s = br.readLine();
                for (int k = 0; k < w; k++) {
                    board[k][j] = s.charAt(k);

                    if (s.charAt(k) == '@') {
                        startX = k;
                        startY = j;
                    } else if (s.charAt(k) == '*') {
                        q.add(new Pair(k, j));
                        visited[k][j] = true;
                    }
                }
            }

            fire = new int[w][h];
            while (!q.isEmpty()) {
                Pair p = q.poll();

                for (int j = 0; j < 4; j++) {
                    int x = p.x + dx[j];
                    int y = p.y + dy[j];

                    if (x < 0 || x >= w || y < 0 || y >= h) {
                        continue;
                    }
                    if (visited[x][y] || board[x][y] == '#') {
                        continue;
                    }

                    fire[x][y] = fire[p.x][p.y] + 1;
                    visited[x][y] = true;
                    q.add(new Pair(x, y));
                }
            }

            sang = new int[w][h];
            visited = new boolean[w][h];
            q = new LinkedList<>();
            visited[startX][startY] = true;
            q.add(new Pair(startX, startY));
            isPossible = false;
            while (!q.isEmpty() && !isPossible) {
                Pair p = q.poll();

                for (int j = 0; j < 4; j++) {
                    int x = p.x + dx[j];
                    int y = p.y + dy[j];

                    if (x < 0 || x >= w || y < 0 || y >= h) {
                        System.out.println(sang[p.x][p.y] + 1);
                        isPossible = true;
                        break;
                    }
                    if (visited[x][y] || board[x][y] == '#' || board[x][y] == '*' || fire[x][y] > 0 && fire[x][y] <= (sang[p.x][p.y] + 1)) {
                        continue;
                    }

                    visited[x][y] = true;
                    sang[x][y] = sang[p.x][p.y] + 1;
                    q.add(new Pair(x, y));
                }
            }

            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
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
}