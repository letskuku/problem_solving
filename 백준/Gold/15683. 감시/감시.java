import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, cctv, ans = 100;
    static int[][] board;
    static List<Pair> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0 && board[i][j] < 6) {
                    list.add(new Pair(i, j));
                }
            }
        }
        cctv = list.size();

        func(0);

        System.out.println(ans);
    }

    static void func(int cur) {
        if (cur == cctv) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0) {
                        sum++;
                    }
                }
            }

            ans = Math.min(ans, sum);
            return;
        }

        Pair p = list.get(cur);
        switch (board[p.x][p.y]) {
            case 1:
                List<Pair> pairs = right(p.x, p.y);
                func(cur + 1);
                rollback(pairs);

                pairs = left(p.x, p.y);
                func(cur + 1);
                rollback(pairs);

                pairs = up(p.x, p.y);
                func(cur + 1);
                rollback(pairs);

                pairs = down(p.x, p.y);
                func(cur + 1);
                rollback(pairs);
                
                break;
            case 2:
                List<Pair> pairs2 = left(p.x, p.y);
                pairs2.addAll(right(p.x, p.y));
                func(cur + 1);
                rollback(pairs2);

                pairs2 = up(p.x, p.y);
                pairs2.addAll(down(p.x, p.y));
                func(cur + 1);
                rollback(pairs2);
                
                break;
            case 3:
                List<Pair> pairs3 = up(p.x, p.y);
                pairs3.addAll(right(p.x, p.y));
                func(cur + 1);
                rollback(pairs3);

                pairs3 = right(p.x, p.y);
                pairs3.addAll(down(p.x, p.y));
                func(cur + 1);
                rollback(pairs3);

                pairs3 = left(p.x, p.y);
                pairs3.addAll(down(p.x, p.y));
                func(cur + 1);
                rollback(pairs3);

                pairs3 = left(p.x, p.y);
                pairs3.addAll(up(p.x, p.y));
                func(cur + 1);
                rollback(pairs3);
                
                break;
            case 4:
                List<Pair> pairs4 = up(p.x, p.y);
                pairs4.addAll(right(p.x, p.y));
                pairs4.addAll(left(p.x, p.y));
                func(cur + 1);
                rollback(pairs4);

                pairs4 = up(p.x, p.y);
                pairs4.addAll(right(p.x, p.y));
                pairs4.addAll(down(p.x, p.y));
                func(cur + 1);
                rollback(pairs4);

                pairs4 = left(p.x, p.y);
                pairs4.addAll(down(p.x, p.y));
                pairs4.addAll(up(p.x, p.y));
                func(cur + 1);
                rollback(pairs4);

                pairs4 = left(p.x, p.y);
                pairs4.addAll(down(p.x, p.y));
                pairs4.addAll(right(p.x, p.y));
                func(cur + 1);
                rollback(pairs4);
            
                break;
            case 5:
                List<Pair> pairs5 = left(p.x, p.y);
                pairs5.addAll(down(p.x, p.y));
                pairs5.addAll(right(p.x, p.y));
                pairs5.addAll(up(p.x, p.y));
                func(cur + 1);
                rollback(pairs5);
        }
    }

    static List<Pair> right(int x, int y) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = y + 1; i < m; i++) {
            if (board[x][i] == 6) {
                break;
            }
            if (board[x][i] == 0) {
                board[x][i] = -1;
                pairs.add(new Pair(x, i));
            }
        }

        return pairs;
    }

    static List<Pair> left(int x, int y) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] == 6) {
                break;
            }
            if (board[x][i] == 0) {
                board[x][i] = -1;
                pairs.add(new Pair(x, i));
            }
        }

        return pairs;
    }

    static List<Pair> up(int x, int y) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 6) {
                break;
            }
            if (board[i][y] == 0) {
                board[i][y] = -1;
                pairs.add(new Pair(i, y));
            }
        }

        return pairs;
    }

    static List<Pair> down(int x, int y) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = x + 1; i < n; i++) {
            if (board[i][y] == 6) {
                break;
            }
            if (board[i][y] == 0) {
                board[i][y] = -1;
                pairs.add(new Pair(i, y));
            }
        }

        return pairs;
    }

    static void rollback(List<Pair> pairs) {
        for (Pair p : pairs) {
            board[p.x][p.y] = 0;
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