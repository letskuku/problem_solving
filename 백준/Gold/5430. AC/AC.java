import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();
            Deque<String> deque = new LinkedList<>();

            if (n != 0) {
                String[] arr = x.substring(1, x.length() - 1).split(",");
                for (int j = 0; j < arr.length; j++) {
                    deque.add(arr[j]);
                }

            }

            Boolean isFront = true;
            for (int j = 0; j < p.length(); j++) {
                char c = p.charAt(j);
                if (c == 'R') {
                    isFront = !isFront;
                } else {
                    if (deque.isEmpty()) {
                        isFront = null;
                        break;
                    }
                    else {
                        if (isFront) {
                            deque.removeFirst();
                        } else {
                            deque.removeLast();
                        }
                    }
                }
            }

            if (isFront == null) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder("[");
            if (isFront) {
                while (deque.size() > 1) {
                    sb.append(deque.removeFirst() + ",");
                }
            } else {
                while (deque.size() > 1) {
                    sb.append(deque.removeLast() + ",");
                }
            }

            if (deque.size() > 0) {
                sb.append(deque.remove());
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}