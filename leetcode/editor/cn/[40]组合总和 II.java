package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution40 {

    List<int[]> freq = new ArrayList<int[]>();

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        Solution40 test = new Solution40();
        List<List<Integer>> lists = test.combinationSum2(nums, 8);


        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(candidates,0, target, result, new ArrayList<>());
        return result;
    }

    public void dfs(int[] candidates, int index, int target, ArrayList<List<Integer>> result, ArrayList<Integer> res) {
        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(res));
            return;
        }

        dfs(candidates, index + 1, target, result, res);

        if (target - candidates[index] > 0) {
            res.add(candidates[index]);
            dfs(candidates, index + 1, target- candidates[index], result, res);
            res.remove(res.size() - 1);
        }
    }
}
