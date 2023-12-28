import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        boolean[] isPrime = new boolean[2000001];

        for (int i = 0; i < 2000001; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(2000000); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 2000001; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = n; i < 2000001; i++) {
            if (isPrime[i] && checkPalindrome(Integer.toString(i))) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }

    public static boolean checkPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }
}