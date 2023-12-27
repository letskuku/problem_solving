import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        double ans = 0;
        List<Integer> drinks = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drinks.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(drinks);

        ans += drinks.get(n - 1);
        for (int i = 0; i < n - 1; i++) {
            ans += ((double) drinks.get(i)) / 2;
        }

        System.out.println(ans);
    }
}