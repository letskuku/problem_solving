import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] board = new int[2][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] d = new int[n][2]; // i번째 열에서 j번째 스티커 고를 때 최대 점수
            d[0][0] = board[0][0];
            d[0][1] = board[1][0];
            if (n > 1) {
                d[1][0] = board[1][0] + board[0][1];
                d[1][1] = board[0][0] + board[1][1];
                for (int j = 2; j < n; j++) {
                    d[j][0] = Math.max(d[j - 1][1], d[j - 2][1]) + board[0][j];
                    d[j][1] = Math.max(d[j - 1][0], d[j - 2][0]) + board[1][j];
                }
            }

            System.out.println(Math.max(d[n - 1][0], d[n - 1][1]));
        }
    }
}