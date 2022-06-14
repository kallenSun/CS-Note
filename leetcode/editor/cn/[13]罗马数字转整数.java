package leetcode.editor.cn;

import java.util.HashMap;

class Solution13 {

    public static void main(String[] args) {
        Solution13 test = new Solution13();
        int i = test.romanToInt("MCMXCIV");
        System.out.println(i);
    }

    public int romanToInt(String s) {
        int sum = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == 'I') {
                if (index < s.length() - 1 && (s.charAt(index + 1) == 'X' || s.charAt(index + 1) == 'V') ) {
                    sum += map.get(s.charAt(index + 1)) - 1;
                    index += 2;
                } else {
                    sum += map.get(c);
                    index++;
                }
            } else if (c == 'X') {
                if ((index < s.length() - 1) && (s.charAt(index + 1) == 'L' || s.charAt(index + 1) == 'C')) {
                    sum += map.get(s.charAt(index+1)) - 10;
                    index += 2;
                } else {
                    sum += map.get(c);
                    index++;
                }
            } else if (c == 'C') {
                if ((index < s.length() - 1) && (s.charAt(index + 1) == 'D' || s.charAt(index + 1) == 'M')) {
                    sum += map.get(s.charAt(index+1)) - 100;
                    index += 2;
                } else {
                    sum += map.get(c);
                    index++;
                }
            } else {
                sum += map.get(c);
                index++;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
