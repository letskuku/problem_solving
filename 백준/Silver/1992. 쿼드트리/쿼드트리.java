import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                 board[j][i] = s.charAt(j);
            }
        }

        func(0, 0, n);

        System.out.println(sb);
    }

    static void func(int r, int c, int n) {
        if (n == 1) {
            sb.append(board[r][c]);
            return;
        }

        boolean split = false;
        for (int i = r; i < r + n; i++) {
            if (split) {
                break;
            }
            for (int j = c; j < c + n; j++) {
                if (board[r][c] != board[i][j]) {
                    split = true;
                    break;
                }
            }
        }

        if (split) {
            int tmp = n / 2;
            sb.append("(");
            func(r, c, tmp);
            func(r + tmp, c, tmp);
            func(r, c + tmp, tmp);
            func(r + tmp, c + tmp, tmp);
            sb.append(")");
        } else {
            sb.append(board[r][c]);
        }
    }
}