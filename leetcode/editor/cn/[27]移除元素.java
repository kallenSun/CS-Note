package leetcode.editor.cn;

class Solution27 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        Solution27 test = new Solution27();
        int i = test.removeElement(nums, 4);
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length ;

        while (left < right) {

            if (nums[left] == val) {
                nums[left] = nums[right -1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
