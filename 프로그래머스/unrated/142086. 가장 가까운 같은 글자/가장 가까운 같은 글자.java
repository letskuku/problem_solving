import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chrArray = s.toCharArray();
        for (int i = 0; i < chrArray.length; i++) {
            if (map.containsKey(chrArray[i])) {
                answer[i] = i - map.get(chrArray[i]);
            } else {
                answer[i] = -1;
            }
            
            map.put(chrArray[i], i);
        }
        
        return answer;
    }
}