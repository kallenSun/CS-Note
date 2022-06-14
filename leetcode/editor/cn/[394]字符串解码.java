package leetcode.editor.cn;

import java.util.Stack;

class Solution394 {


    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int multi = 0;
        Stack<Character> stackChar = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stackNum.push(multi);
            }
        }

        return sb.reverse().toString();
    }


}
