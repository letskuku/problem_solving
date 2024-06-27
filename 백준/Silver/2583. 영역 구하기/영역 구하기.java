import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean[][] board = new boolean[n][m];
        int firX, firY, secX, secY;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            firX = Integer.parseInt(st.nextToken());
            firY = Integer.parseInt(st.nextToken());
            secX = Integer.parseInt(st.nextToken());
            secY = Integer.parseInt(st.nextToken());

            for (int j = firX; j < secX; j++) {
                for (int g = firY; g < secY; g++) {
                    board[j][g] = true;
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j]) {
                    continue;
                }

                int sum = 1;
                board[i][j] = true;
                q.add(new Pair(i, j));
                while (!q.isEmpty()) {
                    Pair p = q.poll();

                    for (int g = 0; g < 4; g++) {
                        int x = p.x + dx[g];
                        int y = p.y + dy[g];

                        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y]) {
                            continue;
                        }

                        sum++;
                        board[x][y] = true;
                        q.add(new Pair(x, y));
                    }
                }

                ans.add(sum);
            }
        }

        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (Integer i : ans) {
            sb.append(i + " ");
        }

        System.out.println(ans.size());
        System.out.println(sb);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}