class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int width = 0, height = 0;
        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0], h = sizes[i][1];
            
            if (w > h) {
                width = Math.max(width, w);
                height = Math.max(height, h);
            } else {
                width = Math.max(width, h);
                height = Math.max(height, w);
            }
        }
        answer = width * height;
        
        return answer;
    }
}