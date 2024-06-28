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

        int l, r, c;
        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, -1, 0, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        int[][][] visited;
        char[][][] building;
        Tuple start = new Tuple(0, 0, 0);
        Tuple exit = new Tuple(0, 0, 0);
        Queue<Tuple> q = new LinkedList<>();
        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            visited = new int[l][r][c];
            building = new char[l][r][c];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = s.charAt(k);

                        if (building[i][j][k] == 'S') {
                            start = new Tuple(i, j, k);
                        } else if (building[i][j][k] == 'E') {
                            exit = new Tuple(i, j, k);
                        }
                    }
                }
                br.readLine();
            }

            q.add(start);
            while (!q.isEmpty()) {
                Tuple t = q.poll();

                for (int i = 0; i < 6; i++) {
                    int x = t.x + dx[i];
                    int y = t.y + dy[i];
                    int z = t.z + dz[i];

                    if (x < 0 || x >= l || y < 0 || y >= r || z < 0 || z >= c) {
                        continue;
                    }
                    if ((x == start.x && y == start.y && z == start.z) || visited[x][y][z] > 0 || building[x][y][z] == '#') {
                        continue;
                    }

                    visited[x][y][z] = visited[t.x][t.y][t.z] + 1;
                    q.add(new Tuple(x, y, z));
                }
            }

            if (visited[exit.x][exit.y][exit.z] > 0) {
                System.out.println("Escaped in " + visited[exit.x][exit.y][exit.z] + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }

    static class Tuple {
        int x, y, z;

        Tuple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}