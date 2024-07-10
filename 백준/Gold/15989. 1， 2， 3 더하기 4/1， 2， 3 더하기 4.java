import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[][] d = new int[10001][4];
        d[1][1] = 1;
        d[2][1] = 1;
        d[2][2] = 1;
        d[3][1] = 1;
        d[3][2] = 1;
        d[3][3] = 1;
        for (int i = 4; i <= 10000; i++) {
            d[i][1] = d[i - 1][1];
            d[i][2] = d[i - 2][1] + d[i - 2][2];
            d[i][3] = d[i - 3][1] + d[i - 3][2] + d[i - 3][3];
        }
        
        while (t-- > 0) {
            int tmp = Integer.parseInt(br.readLine());
            System.out.println(d[tmp][1] + d[tmp][2] + d[tmp][3]);
        }
    }
}