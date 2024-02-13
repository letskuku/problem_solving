import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }

            tree.add(Integer.parseInt(str));
        }

        func(0, tree.size() - 1);
    }

    static void func(int start, int end) {
        if (start > end) {
            return;
        }

        int root = tree.get(start);
        int mid = start + 1;
        while (mid <= end && tree.get(mid) < root) {
            mid++;
        }

        func(start + 1, mid - 1);
        func(mid, end);
        System.out.println(root);
    }
}