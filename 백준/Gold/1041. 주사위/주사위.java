import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Long n = Long.parseLong(br.readLine());
        long one, two, three;

        st = new StringTokenizer(br.readLine());
        List<Long> dice = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            dice.add(Long.parseLong(st.nextToken()));
        }

        List<Long> diceSumForTwo = new ArrayList<>();
        diceSumForTwo.add(dice.get(0) + dice.get(5));
        diceSumForTwo.add(dice.get(1) + dice.get(4));
        diceSumForTwo.add(dice.get(2) + dice.get(3));

        List<Long> diceSumForThree = new ArrayList<>();
        for (int i = 2; i < 4; i++) {
            diceSumForThree.add(dice.get(i) + dice.get(0) + dice.get(1));
            diceSumForThree.add(dice.get(i) + dice.get(0) + dice.get(4));
            diceSumForThree.add(dice.get(i) + dice.get(1) + dice.get(5));
            diceSumForThree.add(dice.get(i) + dice.get(4) + dice.get(5));
        }

        Collections.sort(dice);
        Collections.sort(diceSumForThree);
        one = dice.get(0);
        three = diceSumForThree.get(0);

        two = dice.get(0) + dice.get(1);
        long firThird = dice.get(0) + dice.get(2);
        long secThird = dice.get(1) + dice.get(2);
        if (diceSumForTwo.contains(two)) {
            two = Math.min(firThird, secThird);
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
            for (int i = 0; i < 5; i++) {
                ans += dice.get(i);
            }
        }

        System.out.println(ans);
    }
}