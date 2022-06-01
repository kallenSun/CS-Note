package leetcode.editor.cn;

class Solution494 {

    public int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, nums[0], target);
        dfs(nums, 0, -nums[0], target);
        return count;
    }

    public void dfs(int[] nums, int index, int sum, int target) {
        if (index >= nums.length) {
            if (sum == target) {
                count++;
            }
        }
        dfs(nums, index + 1, sum + nums[index], target);
        dfs(nums, index + 1, sum - nums[index], target);
    }
}
