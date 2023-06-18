package leetcode.editor.cn;


import java.util.HashMap;

class Solution1021 {


    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int left = 0;
        int right = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                result.append(s, start + 1, i - 1);
                start = i+1;
            }
        }
        return result.toString();
    }
}

