package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
class Solution78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backTrack(result, nums, 0, new ArrayList<>());
        return result;
    }

    public void backTrack(ArrayList<List<Integer>> result, int[] nums, int index, ArrayList<Integer> res) {
        if (index == nums.length) {
            result.add(new ArrayList<>(res));
        } else {
            res.add(nums[index]);
            backTrack(result, nums, index + 1, res);
            res.remove(res.size() - 1);
            backTrack(result, nums, index + 1, res);
        }
    }

}
