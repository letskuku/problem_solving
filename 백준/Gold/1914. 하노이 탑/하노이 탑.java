import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static long k = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n <= 20) {
            func(1, 3, n);

            System.out.println(k);
            System.out.println(sb);
        } else {
            BigInteger k = new BigInteger("2");

            System.out.println(k.pow(n).subtract(new BigInteger("1")));
        }
    }

    static void func(int start, int end, int idx) {
        if (idx == 1) {
            k++;
            sb.append(start + " " + end + '\n');

            return;
        }

        func(start, 6 - (start + end), idx - 1);

        k++;
        sb.append(start + " " + end + '\n');

        func(6 - (start + end), end, idx - 1);
    }
}