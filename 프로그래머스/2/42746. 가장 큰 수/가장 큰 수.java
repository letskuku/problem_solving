import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        Collections.sort(list, (s1, s2) -> {
            int tmp1 = Integer.parseInt(s1 + s2);
            int tmp2 = Integer.parseInt(s2 + s1);
            
            return tmp2 - tmp1;
        });
            
        for (int i = 0; i < list.size(); i++) {
            answer = answer.concat(list.get(i));
        }
        
        if (list.get(0).equals("0")) {
            answer = "0";
        }
        
        return answer;
    }
}