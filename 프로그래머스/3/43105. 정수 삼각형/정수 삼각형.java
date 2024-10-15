class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int row = triangle.length;
        int col = triangle[row - 1].length;
        int[][] dp = new int[row][col];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][0];
                } else if (j == i) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = triangle[i][j] + 
                        Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        for (int i = 0; i < col; i++) {
            answer = Math.max(dp[row - 1][i], answer);
        }
        
        return answer;
    }
}