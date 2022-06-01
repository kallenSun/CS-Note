package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class Solution20 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                stack.push(s.charAt(i));
            } else if (stack.empty() ||!stack.pop().equals(map.get(s.charAt(i)))) {
                    return false;
            }

        }
        return stack.size() == 0;

    }
}
