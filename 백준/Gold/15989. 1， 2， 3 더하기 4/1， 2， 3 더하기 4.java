import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] d = new int[10001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 3;
        for (int i = 4; i <= 10000; i++) {
            d[i] = d[i - 1];

            if (i % 2 == 0) {
                d[i]++;
            }

            if (i % 3 == 0) {
                d[i]++;
            }

            for (int j = i - 3; j >= 2; j -= 3) {
                if (j % 2 == 0) {
                    d[i]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(d[Integer.parseInt(br.readLine())] + "\n");
        }

        System.out.println(sb);
    }
}