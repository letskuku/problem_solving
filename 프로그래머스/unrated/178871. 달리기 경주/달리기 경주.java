import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> people = new HashMap<>();
        HashMap<Integer, String> rank = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            people.put(players[i], i);
            rank.put(i, players[i]);
        }
        
        for (String s : callings) {
            int curRank = people.get(s);
            String frontName = rank.get(curRank - 1);
            
            people.put(s, curRank - 1);
            people.put(frontName, curRank);
            rank.put(curRank, frontName);
            rank.put(curRank - 1, s);
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = rank.get(i);
        }
            
        return answer;
    }
}