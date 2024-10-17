import java.util.*;

class Solution {
    static String[] strs = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        func("");
        answer = list.indexOf(word);
        
        return answer;
    }
    
    static void func(String s) {
        if (s.length() > 5) {
            return;
        }
        
        list.add(s);
        for (int i = 0; i < 5; i++) {
            func(s + strs[i]);
        }
    }
}