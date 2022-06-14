package leetcode.editor.cn;


import java.util.Arrays;

class Solution {
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        return 0;
    }

    public static void main(String[] args) {
        Character.isUpperCase('A');
    }

    public static String test(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, (a, b) -> {
            return (a + b).compareTo(b + a);
        });

        StringBuilder res = new StringBuilder();
        for (String s : strArr) {
            res.append(s);
        }
        return res.toString();

    }


}