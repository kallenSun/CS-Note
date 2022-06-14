package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

class Solution728 {

    public static void main(String[] args) {
        Solution728 test = new Solution728();
        test.selfDividingNumbers(1,22);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isValid(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isValid(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}
