import java.io.*;
import java.util.*;

public class Main {

    public static List<Lesson> list = new ArrayList<>();
    public static boolean[][] visited = new boolean[6][11];
    public static int k;
    public static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 수업 요일이 금요일인 경우 저장하지 않음
            if (day != 5) {
                list.add(new Lesson(day, start, end));
            }
        }

        func(0, 0);
        System.out.println(ans);
    }

    public static void func(int curTime, int curIndex) { // 현재까지 신청한 학점, 수강 가능 여부 확인한 수업 수

        // 원하는 수강 학점이 된 경우 ans + 1
        if (curTime == k) {
            ans++;
            return;
        }

        for (int i = curIndex; i < list.size(); i++) {
            Lesson lesson = list.get(i);

            // 원하는 수강 학점을 초과하지 않는지 확인
            int time = lesson.end - lesson.start + 1;
            if (curTime + time > k) {
                continue;
            }

            // 이미 신청한 수업과 시간이 겹치지 않는지 확인
            boolean check = true;
            for (int j = lesson.start; j <= lesson.end; j++) {
                if (visited[lesson.day][j]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                for (int j = lesson.start; j <= lesson.end; j++) {
                    visited[lesson.day][j] = true;
                }

                func(curTime + time, i + 1);

                for (int j = lesson.start; j <= lesson.end; j++) {
                    visited[lesson.day][j] = false;
                }
            }
        }
    }

    public static class Lesson {
        int day, start, end;

        Lesson(int day, int start, int end) {
            this.day = day;
            this.start = start;
            this.end = end;
        }
    }
}