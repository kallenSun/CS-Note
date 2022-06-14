package leetcode.editor.cn;

import sun.nio.cs.ext.MacHebrew;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int mul = nums[i];
            for (int j = i; j < nums.length; j++) {
                mul *= nums[j];
                max = Math.max(max, mul);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
