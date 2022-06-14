package leetcode.editor.cn;//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 
// 👍 304 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution524 {

    public static void main(String[] args) {
        String s = "hello";
        String s1 = "hello";
        System.out.println(s.equals(s1));
        System.out.println(s==s1);

    }

    public static String findLongestWord(String s, List<String> dictionary) {

        Collections.sort(dictionary, new Comparator<String>() {
            public int compare(String word1, String word2) {
                if (word1.length() != word2.length()) {
                    return word2.length() - word1.length();
                } else {
                    return word1.compareTo(word2);
                }
            }
        });

        boolean flag = true;
        int index = 0;
        int max = 0;
        HashMap<Character, Integer> strMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (strMap.get(s.charAt(i)) == null) {
                strMap.put(s.charAt(i), 1);
            } else {
                strMap.put(s.charAt(i), strMap.get(s.charAt(i)) + 1);
            }
        }
        HashMap<Character, Integer> map;

        for (int i = 0; i < dictionary.size(); i++) {
            flag = true;
            String str = dictionary.get(i);
            map = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                if (strMap.get(str.charAt(j)) == null) {
                    flag = false;
                    break;
                }
                if (map.get(str.charAt(j)) == null) {
                    map.put(str.charAt(j), 1);
                    continue;
                } else {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                }
                if (map.get(str.charAt(j)) != null) {
                    int dicNum = map.get(s.charAt(j));
                    int strNum = strMap.get(s.charAt(j));
                    if (dicNum > strNum) {
                        flag = false;
                        break;
                    }
                }

            }
            if (flag && str.length() > max) {
                max = str.length();
                index = i;
            }
        }
        return dictionary.get(index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
