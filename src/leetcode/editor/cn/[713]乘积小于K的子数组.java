package leetcode.editor.cn;

/**
 * 给定一个正整数数组 nums和整数 k 。
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 * 示例 1:
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 * 示例 2:
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *
 *
 * 提示:
 *  1 <= nums.length <= 3 * 104
 *  1 <= nums[i] <= 1000
 *  0 <= k <= 106
 */
class Solution713 {

    public static void main(String[] args) {
        int i = numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19);
    }


    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        double logK = Math.log(k);
        double[] preSum = new double[nums.length];
        int count = 0;
//        preSum[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            preSum[i] = preSum[i-1] * nums[i];
//        }
//        for (int i = 0; i < preSum.length; i++) {
//            if (preSum[i] < k) {
//                count++;
//            }
//            for (int j = i+1; j < preSum.length; j++) {
//                long num = preSum[j] / preSum[i];
//                if (num < k) {
//                    count++;
//                }
//            }
//        }
        return count;
    }
}
