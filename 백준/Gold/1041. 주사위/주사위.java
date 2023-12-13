import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Long n = Long.parseLong(br.readLine());
        long one = 51;
        long two = 101;
        long three = 151;
        long max = 0;

        st = new StringTokenizer(br.readLine());
        long[] dice = new long[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            one = min(one, dice[i]);
            max = max(max, dice[i]);

            for (int j = i + 1; j < 6; j++) {
                if (i + j == 5) {
                    continue; // 마주보는 경우 제외
                }
                two = min(two, dice[i] + dice[j]);

                for (int k = j + 1; k < 6; k++) {
                    if (j + k == 5 || k + i == 5) {
                        continue; // 마주보는 경우 제외
                    }
                    three = min(three, dice[i] + dice[j] + dice[k]);
                }
            }
        }

        Long ans = 0L;

        // 맨위 & 모서리 4개
        ans = ans + 4 * three;

        // 그냥 맨위
        ans = ans + (4 * (n - 2)) * two;

        // 그냥 모서리
        ans = ans + (4 * (n - 1)) * two;

        // 그냥
        ans = ans + ((n - 2) * (n - 2) + 4 * (n - 2) * (n - 1)) * one;

        if (n == 1L) {
            ans = 0L;
            for (int i = 0; i < 6; i++) {
                ans += dice[i];
            }
            ans -= max;
        }

        System.out.println(ans);
    }
}