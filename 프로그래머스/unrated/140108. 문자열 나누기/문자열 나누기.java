class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] array = s.toCharArray();
        int start = 0;
        int x = 0;
        int notX = 0;
        for (int i = start; i < array.length; i++) {
            if (array[i] == array[start]) {
                x++;
            } else {
                notX++;
            }
            
            if (x == notX) {
                start = i + 1;
                answer++;
            }
        }
        
        if (x != notX) {
            answer++;
        }
        
        return answer;
    }
}