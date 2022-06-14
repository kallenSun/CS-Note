package leetcode.editor.cn;

class Solution125 {

    public static void main(String[] args) {
        Solution125 test = new Solution125();
        boolean flag = test.isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                result.append(s.charAt(i));
            }
        }

        int left = 0;
        int right = result.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(result.charAt(left)) != Character.toLowerCase(result.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
