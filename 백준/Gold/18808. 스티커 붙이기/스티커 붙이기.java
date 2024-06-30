import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, size;
    static int[][] board;
    static List<Tuple> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[r][c];
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int g = 0; g < c; g++) {
                    sticker[j][g] = Integer.parseInt(st.nextToken());
                }
            }

            list.add(new Tuple(r, c, sticker));
        }
        size = list.size();

        func(0, 0);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static void func(int cur, int dir) {
        if (cur == size) {
            return;
        }

        Tuple t = list.get(cur);
        boolean attached = false;
        for (int i = 0; i < n; i++) {
            if (attached) {
                break;
            }
            for (int j = 0; j < m; j++) {
                boolean tmp = true;
                int ii;
                int jj;
                switch (dir) {
                    case 0:
                        ii = i;
                        for (int g = 0; g < t.r; g++) {
                            if (!tmp) {
                                break;
                            }
                            jj = j;
                            for (int h = 0; h < t.c; h++) {
                                if (ii < 0 || ii >= n || jj < 0 || jj >= m) {
                                    tmp = false;
                                    break;
                                }
                                if (board[ii][jj] == 1 && t.sticker[g][h] == 1) {
                                    tmp = false;
                                    break;
                                }
                                jj++;
                            }
                            ii++;
                        }

                        if (tmp) {
                            ii = i;
                            for (int g = 0; g < t.r; g++) {
                                jj = j;
                                for (int h = 0; h < t.c; h++) {
                                    if (t.sticker[g][h] == 1) {
                                        board[ii][jj] = 1;
                                    }
                                    jj++;
                                }
                                ii++;
                            }

                            attached = true;
                        }

                        break;
                    case 1:
                        ii = i;
                        for (int g = 0; g < t.c; g++) {
                            if (!tmp) {
                                break;
                            }
                            jj = j;
                            for (int h = t.r - 1; h >= 0; h--) {
                                if (ii < 0 || ii >= n || jj < 0 || jj >= m) {
                                    tmp = false;
                                    break;
                                }
                                if (board[ii][jj] == 1 && t.sticker[h][g] == 1) {
                                    tmp = false;
                                    break;
                                }
                                jj++;
                            }
                            ii++;
                        }

                        if (tmp) {
                            ii = i;
                            for (int g = 0; g < t.c; g++) {
                                jj = j;
                                for (int h = t.r - 1; h >= 0; h--) {
                                    if (t.sticker[h][g] == 1) {
                                        board[ii][jj] = 1;
                                    }
                                    jj++;
                                }
                                ii++;
                            }

                            attached = true;
                        }

                        break;
                    case 2:
                        ii = i;
                        for (int g = t.r - 1; g >= 0; g--) {
                            if (!tmp) {
                                break;
                            }
                            jj = j;
                            for (int h = t.c - 1; h >= 0; h--) {
                                if (ii < 0 || ii >= n || jj < 0 || jj >= m) {
                                    tmp = false;
                                    break;
                                }
                                if (board[ii][jj] == 1 && t.sticker[g][h] == 1) {
                                    tmp = false;
                                    break;
                                }
                                jj++;
                            }
                            ii++;
                        }

                        if (tmp) {
                            ii = i;
                            for (int g = t.r - 1; g >= 0; g--) {
                                jj = j;
                                for (int h = t.c - 1; h >= 0; h--) {
                                    if (t.sticker[g][h] == 1) {
                                        board[ii][jj] = 1;
                                    }
                                    jj++;
                                }
                                ii++;
                            }

                            attached = true;
                        }

                        break;
                    case 3:
                        ii = i;
                        for (int g = t.c - 1; g >= 0; g--) {
                            if (!tmp) {
                                break;
                            }
                            jj = j;
                            for (int h = 0; h < t.r; h++) {
                                if (ii < 0 || ii >= n || jj < 0 || jj >= m) {
                                    tmp = false;
                                    break;
                                }
                                if (board[ii][jj] == 1 && t.sticker[h][g] == 1) {
                                    tmp = false;
                                    break;
                                }
                                jj++;
                            }
                            ii++;
                        }

                        if (tmp) {
                            ii = i;
                            for (int g = t.c - 1; g >= 0; g--) {
                                jj = j;
                                for (int h = 0; h < t.r; h++) {
                                    if (t.sticker[h][g] == 1) {
                                        board[ii][jj] = 1;
                                    }
                                    jj++;
                                }
                                ii++;
                            }

                            attached = true;
                        }
                }

                if (attached) {
                    break;
                }
            }
        }

        if (attached || dir == 3) {
            func(cur + 1, 0);
        } else {
            func(cur, dir + 1);
        }
    }

    static class Tuple {
        int r, c;
        int[][] sticker;

        Tuple(int r, int c, int[][] sticker) {
            this.r = r;
            this.c = c;
            this.sticker = sticker;
        }
    }
}