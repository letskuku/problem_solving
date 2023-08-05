import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
        }
    
        Collections.sort(list);
        for (int i = list.size() - m; i >= 0; i -= m) {
            answer += list.get(i) * m;
        }
        
        return answer;
    }
}