import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        List<Pair> photos = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int cur = Integer.parseInt(st.nextToken());

            int idx = -1;
            int min = 1001;
            boolean added = false;
            for (int j = 0; j < photos.size(); j++) {
                Pair p = photos.get(j);

                if (p.x == cur) {
                    p.y++;
                    added = true;
                    break;
                }

                if (p.y < min) {
                    idx = j;
                    min = p.y;
                }
            }

            if (!added) {
                if (photos.size() == n) {
                    photos.remove(idx);
                }
                photos.add(new Pair(cur, 1));
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < photos.size(); i++) {
            result.add(photos.get(i).x);
        }
        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}