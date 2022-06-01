package leetcodeLocal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2021/12/28 <br>
 * @since V9.0 <br>
 */
public class Solution {

    ArrayList<Integer> result = new ArrayList<>();

    static private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    // [2,4,3]
    //[5,6,4]
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
        }
        Arrays.sort(score);
        // 没过线的人数
        int notOk = n - y;
        if (notOk > y){
            System.out.println(-1);
        }else if (notOk >= x && notOk <= y){
            System.out.println(score[n-y-1]);
        }else{
            System.out.println(score[x-1]);
        }
    }


     static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    // 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    // 你可以按任意顺序返回答案。
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherValue = target - nums[i];
            if (map.containsKey(otherValue)) {
                res[0] = i;
                res[1] = map.get(otherValue);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int co = 0;
        while (l1 != null || l2 != null) {
             int s1 = l1 != null ? l1.val : 0;
             int s2 = l2 != null ? l2.val : 0;
             int sum = s1 + s2 + co;
             cur.next = new ListNode(sum % 10);
             co = sum / 10;
             cur = cur.next;

             if (l1 != null) {
                 l1 = l1.next;
             }
             if (l2 != null) {
                 l2 = l2.next;
             }
         }
        if (co > 0) {
            cur.next = new ListNode(co);
        }
        return pre.next;
    }

    // 3.给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
    // 输入: s = "abcabcbb"
    // 输出: 3
    // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public static int lengthOfLongestSubstring(String s) {
         int max = 0;
         int start = 0;
         HashMap<Character, Integer> map = new HashMap<>();
         for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (map.containsKey(c)) {
                 start = Math.max(start, map.get(c) + 1);
             }
             map.put(c, i);
             max = Math.max(max, i - start + 1);
         }
        return max;
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int len = s.length();
        int start = 0;
        int max = 1;
        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int currentMaxLen = Math.max(len1, len2);
            if (currentMaxLen > max) {
                start = i;
                max = currentMaxLen;
            }
        }
        return s.substring(start, start + max);
    }

    public int expandAroundCenter(String str, int left, int right) {
         while ((left >= 0 && right < str.length()) && str.charAt(left) == str.charAt(right)) {
             --left;
             ++right;
         }
         return right - left - 1;
    }

    // 接雨水
    public int maxArea(int[] height) {
         int max = 0;
         int left = 0;
         int right = height.length - 1;
         while (left < right) {
             int area = Math.min(height[left], height[right]) * (right - left);
             max = Math.max(max, area);
             if (height[left] < height[right]) {
                 left++;
             } else {
                 right--;
             }
         }
         return max;
    }

    // 三数之和
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int left = i+1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(left);
                    res.add(right);
                    res.add(i);
                    result.add(res);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left++]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right--]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    // 电话号码字母组合
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(digits, res, map, new StringBuilder(), 0);
        return res;
    }

    public void dfs(String digits, List<String> res, Map<Character, String> map, StringBuilder sb, int index) {
         if (index == digits.length()) {
             res.add(sb.toString());
         } else {
             String letter = map.get(digits.charAt(index));
             for (int j = 0; j < letter.length(); j++) {
                 sb.append(letter.charAt(j));
                 dfs(digits, res, map, sb, index + 1);
                 sb.deleteCharAt(index);
             }
         }
    }

    // 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


    // 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
    // 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
    // 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j*j >= 0; j++) {
                dp[i] = Math.min(dp[i-j*j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    // 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            ArrayList<Integer> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue = tmp;
            if(res.size() % 2 == 1) {
                Collections.reverse(res);
            }
            result.add(res);
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            int maxLen = 0;
            set.add(s.charAt(i));
            int j = i;
            while (j < n && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLen++;
                j++;
            }
            max = Math.max(max, maxLen);
        }
        return max;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        if (root.left != null) {
            root.left = mirrorTree(root.left);
        }
        if (root.right != null) {
            root.right = mirrorTree(root.right);
        }
        return root;
    }


    public List<String> simplifiedFractions(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    result.add(j + "/" + i);
                }
            }
        }
        return result;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public int maxPower(String s) {
        int max = 1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = i;
            while (index < n) {
                if (s.charAt(i) != s.charAt(index)) {
                    break;
                }
                index++;
            }
            max = Math.max(max, index - i);
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length ; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (targetSum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }

    public int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 || num2 != 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }

    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        long min = Long.MAX_VALUE;
        long sum = 0;
        Arrays.sort(beans);
        for (int i = 0; i < n; i++) {
            sum += beans[i];
        }

        for (int i = 0; i < n; i ++) {
            long postSum = sum - (beans[i] * (long)(n - i));
            min = Math.min(min, postSum);
        }
        return min;
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return pre.next;
    }

    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num + 1);
        }
        for (int num : nums) {
            if (map.get(num) != null && map.get(num - 1) == null) {
                int other = map.get(num);
                while (map.get(other) != null) {
                    other = map.get(other);
                }
                max = Math.max(max, other - num + 1);
            }
        }
        return max;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[n-1];
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
                if (j == n-1) {
                    res[i] = 0;
                }
            }
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i < n; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            if (map.get(pre) == null) {
                map.put(pre, 0);
            } else {
                map.put(pre, map.get(pre) + 1);
            }
        }
        return count;
    }

    public int minPathSum(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        for(int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for(int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        max = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return max;
    }

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int[] dp = new int[str.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            String tmpStr = str.substring(i - 2, i);
            if (tmpStr.compareTo("10") >= 0 && tmpStr.compareTo("25") <= 0) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }

    // 152. 乘积最大子数组
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int result = nums[0];
        int[] max = new int[n];
        int[] min = new int[n];
        for (int i = 2; i < n; i++) {
            max[i] = Math.max(nums[i] * max[i-1], Math.max(nums[i],nums[i] * min[i]));
            min[i] = Math.min(min[i-1] * nums[i], Math.min(nums[i], max[i] * nums[i]));
            result = Math.max(result, max[i]);
        }
        return result;
    }

    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder res = new StringBuilder();
        res.append(nums[0]);
        res.append("/(");
        res.append(nums[1]);
        for (int i = 2; i < n; i++) {
            res.append("/");
            res.append(nums[i]);
        }
        res.append(")");
        return res.toString();
    }

//    public int numIslands(char[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int count = 0;
//        boolean[][] dp = new boolean[m][n];
//        for (int i = 0; i < m; i++) {
//            dp[i][n-1] = false;
//            dp[i][0] = false;
//        }
//        for (int i = 0; i < n; i++) {
//            dp[m-1][i] = false;
//            dp[m-1][0] = false;
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//
//            }
//        }
//    }


}
