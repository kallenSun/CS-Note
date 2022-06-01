package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *  示例 1：
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 *  示例 2：
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 *
 *  提示:
 *  二叉树的节点个数的范围是 [1, 104].
 *  -104 <= Node.val <= 104
 *  root 为二叉搜索树
 *  -105 <= k <= 105
 */
class Solution653 {

    public static void main(String[] args) {
        Solution653 solution = new Solution653();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode();
        root.right = new TreeNode(3);

        boolean target = solution.findTarget(root, 6);
        System.out.println(target);
    }

    public Map<Integer, Boolean> map = new HashMap<>();

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    public boolean dfs(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        int otherValue = target - node.val;
        if (map.get(otherValue) != null) {
            return true;
        } else {
            map.put(node.val, true);
            return dfs(node.left, target) || dfs(node.right, target);
        }
    }
}
