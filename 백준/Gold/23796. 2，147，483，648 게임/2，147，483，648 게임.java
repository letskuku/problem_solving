import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[][] board = new long[8][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 8; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 8; j++) {
                board[i][j] = Long.parseLong(st.nextToken());
            }
        }

        String s = br.readLine();
        int dir = 0;
        if (s.equals("U")) {
            dir = 1;
        } else if (s.equals("R")) {
            dir = 2;
        } else if (s.equals("D")) {
            dir = 3;
        }

        for (int i = 0; i < dir; i++) {
            rotate();
        }

        for (int i = 0; i < 8; i++) {
            int preIdx = 0;

            for (int j = 1; j < 8; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                if (board[i][preIdx] == 0) {
                    board[i][preIdx] = board[i][j];
                    board[i][j] = 0;
                } else if (board[i][preIdx] == board[i][j]) {
                    board[i][preIdx++] *= 2;
                    board[i][j] = 0;
                } else {
                    board[i][++preIdx] = board[i][j];
                    if (preIdx != j) {
                        board[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < (4 - dir) % 4; i++) {
            rotate();
        }

        for (int i = 0; i < 8; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                sb.append(board[i][j] + " ");
            }

            System.out.println(sb);
        }
    }

    static void rotate() {
        long[][] tmp = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tmp[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = tmp[j][7 - i];
            }
        }
    }
}