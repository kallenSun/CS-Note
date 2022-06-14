package leetcode.editor.cn;//给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，按 升序排列 返回一个数组，数组中的每个元素在 nums 所有
//数组 中都出现过。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
//输出：[3,4]
//解释：
//nums[0] = [3,1,2,4,5]，nums[1] = [1,2,3,4]，nums[2] = [3,4,5,6]，在 nums 中每个数组中都出现
//的数字是 3 和 4 ，所以返回 [3,4] 。 
//
// 示例 2： 
//
// 
//输入：nums = [[1,2,3],[4,5,6]]
//输出：[]
//解释：
//不存在同时出现在 nums[0] 和 nums[1] 的整数，所以返回一个空列表 [] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= sum(nums[i].length) <= 1000 
// 1 <= nums[i][j] <= 1000 
// nums[i] 中的所有值 互不相同 
// 
// Related Topics 数组 哈希表 计数 
// 👍 17 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2248 {

    public static void main(String[] args) {
        int[] num1 = {3, 1, 2, 4, 5};
        int[] num2 = {1, 2,3, 4};
        int[] num3 = {3,4, 5,6};

        int[][] nums = new int[3][3];
        nums[0] = num1;
        nums[1] = num2;
        nums[2] = num3;

        Solution2248 test = new Solution2248();
        test.intersection(nums);

    }

    public List<Integer> intersection(int[][] nums) {

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums[0].length; i++) {
            map.put(nums[0][i], 1);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int item : nums[i]) {
                HashMap<Integer, Integer> temp = new HashMap<>();
                temp.putIfAbsent(item, 1);

                temp.forEach((key,value) ->{
                    if (map.get(key) != null) {
                        map.put(key, map.get(key) + 1);
                    }
                });
            }
        }

        map.forEach((key, value) ->{
            if (value == nums.length) {
                result.add(key);
            }
        });

        Collections.sort(result);

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
