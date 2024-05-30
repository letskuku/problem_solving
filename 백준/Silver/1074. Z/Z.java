import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(func(n, r, c));
    }

    public static int func(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = 1 << (n - 1);
        if (r < half && c < half) {
            return func(n - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + func(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + func(n - 1, r - half, c);
        } else {
            return 3 * half * half + func(n - 1, r - half, c - half);
        }
    }
}