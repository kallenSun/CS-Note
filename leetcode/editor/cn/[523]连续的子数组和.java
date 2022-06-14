package leetcode.editor.cn;

class Solution523 {

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 6};
        boolean b = checkSubarraySum(nums, 7);
        System.out.println(b);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1 ; j < nums.length; j++) {
                int sum = nums[i];
                sum += nums[j];
                System.out.println(sum);
                if (sum >= k && ((sum % k) == 0)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
