package leetcode.editor.cn;

class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        int start = 0;

        char[] charArray = s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int right = 1; right < n; right++) {
            for (int left = 0; left < n; left++) {
                if (charArray[left] != charArray[right]) {
                    dp[left][right] = false;
                } else {
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right] && (right - left + 1) > max) {
                    max = right - left + 1;
                    start = left;
                }
            }
        }

        return s.substring(start, start + max);
    }
}
