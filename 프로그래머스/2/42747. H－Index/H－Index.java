import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int len = citations.length;
        Arrays.sort(citations);
        for (int i = 1; i <= len; i++) {
            if (citations[len - i] >= i) {
                answer = i;
            }
        }
        
        return answer;
    }
}