import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int l, c;
    static List<String> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            list.add(st.nextToken());
        }
        Collections.sort(list);

        func(0, 0, -1, "");

        System.out.println(sb);
    }

    static void func(int one, int two, int last, String pw) {
        if (pw.length() == l) {
            if (one >= 1 && two >= 2) {
                sb.append(pw + '\n');
            }

            return;
        }

        for (int i = last + 1; i < c; i++) {
            if (list.get(i).equals("a") || list.get(i).equals("e") || list.get(i).equals("i") ||
                    list.get(i).equals("o") || list.get(i).equals("u")) {
                func(one + 1, two, i, pw + list.get(i));
            } else {
                func(one, two + 1, i, pw + list.get(i));
            }
        }
    }
}