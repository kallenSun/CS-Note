package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution17 {

    public static void main(String[] args) {
        Solution17 test = new Solution17();
        List<String> res = test.letterCombinations("23");
        for (String re : res) {
            System.out.println(re);
        }
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backTrack(result, map, 0, digits, new StringBuilder());
        return result;
    }

    public void backTrack(ArrayList<String> result, HashMap<Character, String> map, int index, String digits, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
        } else {
            String str = map.get(digits.charAt(index));
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                backTrack(result, map, index + 1, digits, sb);
                sb.deleteCharAt(index);
            }
        }
    }



    public int test(String str) {
        int count = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'o') {
                count++;
                if (count % 2 == 0) {
                    end = i;
                }
            }
        }
        return end;
    }


}
