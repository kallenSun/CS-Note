package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 */
class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        dfs(result, res, candidates,0, target );
        return result;
    }

    public void dfs(List<List<Integer>> result, ArrayList<Integer> res, int[] candidates, int index, int target) {
        if (index == candidates.length) {
            return;
        }

        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(res));
        } else {
            res.add(candidates[index]);
            dfs(result, res, candidates, index, target - candidates[index]);
            res.remove(res.size() - 1);
            dfs(result, res, candidates, index + 1, target);
        }
    }
}
