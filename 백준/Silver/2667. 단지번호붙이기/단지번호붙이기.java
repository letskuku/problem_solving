import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        char[][] board = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        Queue<Pair> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int sum;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '0' || visited[i][j]) {
                    continue;
                }

                sum = 1;
                q.add(new Pair(i, j));
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    Pair p = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int x = p.x + dx[k];
                        int y = p.y + dy[k];

                        if (x < 0 || x >= n || y < 0 || y >= n) {
                            continue;
                        }
                        if (board[x][y] == '0' || visited[x][y]) {
                            continue;
                        }

                        sum++;
                        visited[x][y] = true;
                        q.add(new Pair(x, y));
                    }
                }

                ans.add(sum);
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (Integer i : ans) {
            System.out.println(i);
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