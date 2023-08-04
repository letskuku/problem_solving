import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(i);
        }
        
        for (char c : skip.toCharArray()) {
            list.remove(list.indexOf(c - 'a'));
        }
        
        int size = list.size();
        for (char c : s.toCharArray()) {
            int newIdx = (list.indexOf(c - 'a') + index) % size;
            char newC = (char)(list.get(newIdx) + 'a');
            
            answer += Character.toString(newC);
        }
        
        return answer;
    }
}