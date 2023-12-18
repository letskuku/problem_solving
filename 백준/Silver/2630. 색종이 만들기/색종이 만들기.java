import java.io.*;
import java.util.*;

public class Main {

    static int[] ans = {0, 0}; // ans[0]: 하얀 색종이, ans[1]: 파란 색종이
    static int[][] papers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        papers = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (func(1, 1, n)) {
            ans[papers[1][1]]++;
        }

        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    public static boolean func(int x, int y, int length) {
        if (length == 1) {
            return true;
        }

        int newLength = length / 2;
        int[][] checkColor = {{x + newLength, y}, {x, y + newLength}, {x + newLength, y + newLength}, {x, y}};
        int[] tmp = {0, 0};
        for (int i = 0; i < 4; i++) {
            if (func(checkColor[i][0], checkColor[i][1], newLength)) {
                tmp[papers[checkColor[i][0]][checkColor[i][1]]]++;
            }
        }

        if ((tmp[0] == 4) || (tmp[1] == 4)) {
            return true; // 4등분한 색종이가 모두 같은 색깔이면 true 반환
        } else {
            ans[0] += tmp[0];
            ans[1] += tmp[1];
            return false;
        }
    }
}