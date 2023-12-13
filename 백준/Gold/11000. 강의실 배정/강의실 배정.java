import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<Pair> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures.add(new Pair(start, end));
        }
        Collections.sort(lectures);

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.add(lectures.get(0).y);
        for (int i = 1; i < n; i++) {
            int start = lectures.get(i).x;
            int end = lectures.get(i).y;

            if (rooms.peek() <= start) {
                rooms.poll();
            }
            rooms.add(end);
        }

        System.out.println(rooms.size());
    }

    public static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {

            if (this.x == o.x) {
                return Integer.compare(this.y, o.y); // 첫번째 인자값이 같으면 두번째 인자로 오름차순 정렬
            }

            return Integer.compare(this.x, o.x); // 첫번째 인자로 오름차순 정렬
        }
    }
}