package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

class Solution22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    public void generateAll(char[] current, int index, List<String> result) {
        if (index == current.length) {
            result.add(new String(current));
            return;
        }

        current[index] = '(';
        generateAll(current, index+1, result);
        current[index] = ')';
        generateAll(current, index+1, result);

    }

}
