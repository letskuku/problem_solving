import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        int prevCol = -1;
        int doubleCol = -1;
        int group = 0;
        int index = 0;
        if ((sb.charAt(0) == ':') && (sb.charAt(1) == ':')) {
            doubleCol = 0;
            prevCol = 1;
            index = 2;
        }

        while (index < sb.length()) {
            if (sb.charAt(index) == ':') {
                int zeroNum = 4 - (index - prevCol -1);
                StringBuilder zeros = new StringBuilder();
                for (int i = 0 ; i < zeroNum; i++) {
                    zeros.append(0);
                }
                sb.insert(prevCol + 1, zeros);
                group++;
                index += zeroNum;

                prevCol = index;
                index++;
                if ((index < sb.length()) && (sb.charAt(index) == ':')) {
                    doubleCol = prevCol;
                    prevCol = index;
                    index++;
                }
            } else {
                index++;
            }
        }

        int lastZeroNum = 4 - (sb.length() - prevCol - 1);
        if (lastZeroNum > 0) {
            StringBuilder zeros = new StringBuilder();
            for (int i = 0 ; i < lastZeroNum; i++) {
                zeros.append(0);
            }
            sb.insert(prevCol + 1, zeros);
            group++;
        } else if (doubleCol != sb.length() - 2) {
            group++;
        }

        if (doubleCol != -1) {
            StringBuilder zeros = new StringBuilder();
            for (int i = 0; i < 8 - group; i++) {
                zeros.append("0000:");
            }
            sb.replace(doubleCol + 1, doubleCol + 2, zeros.toString());

            if (doubleCol == 0) {
                sb = new StringBuilder(sb.substring(1));
            }
        }

        System.out.println(sb);
    }
}