class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        boolean check = true;
        int start1 = 0;
        int start2 = 0;        
        for (String s : goal) {
            if (start1 < cards1.length && cards1[start1].equals(s)) {
                start1++;
            } else if (start2 < cards2.length && cards2[start2].equals(s)) {
                start2++;
            } else {
                check = false;
                break;
            }
        }
        
        if (check) {
            answer += "Yes";
        } else {
            answer += "No";
        }
        
        return answer;
    }
}