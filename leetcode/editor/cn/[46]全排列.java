package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

class Solution46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution46 test = new Solution46();
        test.permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        dfs(result, new ArrayList<>(), nums, 0, visited);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> res, int[] nums, int index, boolean[] visited) {
        // res.size() == nums.length 说明已经存够了，大部分回溯的判断条件是index == nums.length
        if (res.size() == nums.length) {
            result.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            res.add(nums[i]);
            // 标记是否访问过
            visited[i] = true;
            dfs(result, res, nums, i + 1, visited);
            res.remove(res.size() - 1);
            // 访问状态重置
            visited[i] = false;
        }
    }
}
