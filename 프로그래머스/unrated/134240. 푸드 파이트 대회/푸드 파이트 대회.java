import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer += Integer.toString(i);
            }
        }
        
        StringBuffer sb = new StringBuffer(answer);
        String reversed = sb.reverse().toString();
        
        answer += Integer.toString(0);
        answer += reversed;
        
        return answer;
    }
}