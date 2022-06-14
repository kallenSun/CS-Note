package leetcode.editor.cn;//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度
//。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 105 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1177 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution739 test = new Solution739();
        int[] nums = {1, 2, 4,6};

        int[] num0 = new int[]{1,3};
        int[] num1 = new int[]{4,7};
        int[] num2 = new int[]{6,1};

        int[][] numArr = new int[3][2];
        numArr[0] = num0;
        numArr[1] = num1;
        numArr[2] = num2;

        int[] ints = test.arrayChange(nums, numArr);
        System.out.println(ints);
    }


    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] arr : operations) {
            map.put(arr[1], map.get(arr[0]));
            map.remove(arr[0]);
        }

        int[] result = new int[nums.length];
        map.forEach((key, value) ->{
            result[value] = key;
        });

        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
