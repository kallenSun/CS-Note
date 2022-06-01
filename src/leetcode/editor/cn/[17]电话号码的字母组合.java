package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution17 {
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

        backTrack(digits, map, 0, result, new StringBuilder());
        return result;
    }

    public void backTrack(String digits, HashMap<Character, String> map, int index, ArrayList<String> result, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
        } else {
            char c = digits.charAt(index);
            String str = map.get(c);
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                backTrack(digits, map, index + 1, result, sb);
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
