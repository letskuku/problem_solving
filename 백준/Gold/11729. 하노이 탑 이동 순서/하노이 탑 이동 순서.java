import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int k = (1 << n) - 1;
        bw.write(k + "\n");
        func(1, 3, n);

        bw.flush();
        bw.close();
    }

    public static void func(int a, int b, int n) throws IOException {
        if (n == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }

        func(a, 6 - a - b, n - 1);
        bw.write(a + " " + b + "\n");
        func(6- a- b, b, n - 1);
    }
}