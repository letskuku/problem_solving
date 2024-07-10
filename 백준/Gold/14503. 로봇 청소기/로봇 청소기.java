import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = new int[0];
        int[] dy = new int[0];
        while (true) {
            if (board[r][c] == 0) {
                board[r][c] = 2;
            }

            switch (d) {
                case 0:
                    dx = new int[]{0, 1, 0, -1};
                    dy = new int[]{-1, 0, 1, 0};

                    break;
                case 1:
                    dx = new int[]{-1, 0, 1, 0};
                    dy = new int[]{0, -1, 0, 1};

                    break;
                case 2:
                    dx = new int[]{0, -1, 0, 1};
                    dy = new int[]{1, 0, -1, 0};

                    break;
                case 3:
                    dx = new int[]{1, 0, -1, 0};
                    dy = new int[]{0, 1, 0, -1};
            }

            int newD = -1;
            int newX = 0;
            int newY = 0;
            for (int i = 0; i < 4; i++) {
                int x = r + dx[i];
                int y = c + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                if (board[x][y] != 0) {
                    continue;
                }

                newD = (d + 3 - i) % 4;
                newX = x;
                newY = y;

                break;
            }

            if (newD >= 0) {
                d = newD;
                r = newX;
                c = newY;
            } else {
                r += dx[1];
                c += dy[1];

                if (r < 0 || r >= n || c < 0 || c >= m || board[r][c] == 1) {
                    break;
                }
            }
        }


        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}