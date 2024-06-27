import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int m, n, k, x, y, ans;
        boolean[][] arr;
        boolean[][] visited;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Stack<Pair> stack;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new boolean[m][n];
            visited = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                arr[x][y] = true;
            }

            ans = 0;
            stack = new Stack<>();
            for (int j = 0; j < m; j++) {
                for (int g = 0; g < n; g++) {
                    if (!arr[j][g] || visited[j][g]) {
                        continue;
                    }

                    ans++;
                    stack.push(new Pair(j, g));
                    visited[j][g] = true;
                    while (!stack.isEmpty()) {
                        Pair p = stack.pop();

                        for (int h = 0; h < 4; h++) {
                            int xx = p.x + dx[h];
                            int yy = p.y + dy[h];

                            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                                continue;
                            }
                            if (!arr[xx][yy] || visited[xx][yy]) {
                                continue;
                            }

                            stack.push(new Pair(xx, yy));
                            visited[xx][yy] = true;
                        }
                    }
                }
            }

            System.out.println(ans);
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