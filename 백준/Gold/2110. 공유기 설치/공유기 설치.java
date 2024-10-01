import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, c;
    static List<Integer> house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            house.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(house);

        int left = 1;
        int right = house.get(n - 1) - house.get(0) + 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;

            if (isInstalled(mid) >= c) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(right - 1);
    }

    static int isInstalled(int len) {
        int cnt = 1;
        int lastHouse = house.get(0);

        for (int i = 1; i < n; i++) {
            if (house.get(i) - lastHouse >= len) {
                cnt++;
                lastHouse = house.get(i);
            }
        }

        return cnt;
    }
}