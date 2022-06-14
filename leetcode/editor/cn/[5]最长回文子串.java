package leetcode.editor.cn;

class Solution5 {

    public static void main(String[] args) {
        Solution5 test = new Solution5();
        String str = test.longestPalindrome("aaaaa");
        System.out.println(str);
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0;
        int max = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int right = 1; right < n; right++) {
            for (int left = 0; left < n; left++) {
                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                } else {
                    if (right - left <= 2) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];

                    }
                }
                if (dp[left][right] && right - left + 1 > max) {
                    max = Math.max(right - left + 1, max);
                    start = left;
                }
            }
        }

        return s.substring(start, start + max);
    }

}
