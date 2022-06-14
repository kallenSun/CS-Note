package leetcode.editor.cn;

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix,  strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        String str = str1.length() < str2.length() ? str1 :str2;
        for (int i = 0; i < str.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str.substring(0, i);
            }
        }
        return str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
