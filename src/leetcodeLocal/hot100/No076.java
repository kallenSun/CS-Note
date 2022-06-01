package leetcodeLocal.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 *
 * 例1:
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 例2:
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class No076 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        No076 test = new No076();
        List<List<Integer>> subsets = test.subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, ArrayList<Integer> res, int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[index]);
        dfs(result, res, nums, index + 1);
        res.remove(res.size() - 1);
        dfs(result, res, nums, index + 1);
    }
}
