import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] nums = new int[9];
        for (int i = 0; i < s.length(); i++) {
            int t = Integer.parseInt(s.substring(i, i + 1));

            if (t == 9) {
                nums[6]++;
            } else {
                nums[t]++;
            }
        }

        if (nums[6] % 2 == 1) {
            nums[6] = (nums[6] / 2) + 1;
        } else {
            nums[6] /= 2;
        }
        Arrays.sort(nums);

        System.out.println(nums[8]);
    }
}