import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        
        Map<String, List<Pair>> map1 = new HashMap<>();
        Map<String, Long> map2 = new HashMap<>();
        for (int i = 0 ; i < genres.length; i++) {
            if (map1.containsKey(genres[i])) {
                List<Pair> tmp = map1.get(genres[i]);
                tmp.add(new Pair(i, plays[i]));
                map1.replace(genres[i], tmp);
                
                map2.replace(genres[i], map2.get(genres[i]) + plays[i]);
            } else {
                List<Pair> tmp = new ArrayList<>();
                tmp.add(new Pair(i, plays[i]));
                map1.put(genres[i], tmp);
                
                map2.put(genres[i], (long)plays[i]);
            }
        }
        
        List<Map.Entry<String, Long>> list = new ArrayList<>(map2.entrySet());
        Collections.sort(list, (e1, e2) -> {
            return (int) (e2.getValue() - e1.getValue());
        });
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String genre = list.get(i).getKey();
            List<Pair> pairs = map1.get(genre);
            
            if (pairs.size() == 1) {
                ans.add(pairs.get(0).id);
            } else {
                Collections.sort(pairs, (p1, p2) -> {
                    if (p1.played == p2.played) {
                        return p1.id - p2.id;
                    }
                    
                    return p2.played - p1.played;
                });
                
                ans.add(pairs.get(0).id);
                ans.add(pairs.get(1).id);
            }
        }
        
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    static class Pair {
        int id, played;
        
        Pair(int id, int played) {
            this.id = id;
            this.played = played;
        }
    }
}