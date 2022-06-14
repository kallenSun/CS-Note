package leetcode.editor.cn;

import java.util.ArrayList;

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

}
