import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a, b, c;
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(func(a, b, c));
    }

    static long func(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long val = func(a, b / 2, c);
        val = val * val % c;

        if (b % 2 == 0) {
            return val;
        }
        return val * a % c;
    }
}