import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> trucks = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int truckW = 0;
        int time = 0;
        while (!trucks.isEmpty()) {
            truckW -= bridge.poll();
            time++;

            if (truckW + trucks.peek() <= L) {
                bridge.add(trucks.peek());
                truckW += trucks.poll();
            } else {
                bridge.add(0);
            }
        }

        System.out.println(time + bridge.size());
    }
}
