package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

class Solution56 {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length - 1; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (result.size() == 0 || result.get(result.size() - 1)[1] < intervals[i][0]) {
                result.add(new int[]{left, right});
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], right);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

    public boolean isBoomerang(int[][] points) {
        int y1 = points[2][1] - points[1][1];
        int x1 = points[2][0] - points[1][0];
        int y2 = points[1][1] - points[0][1];
        int x2 = points[1][0] - points[0][0];

        return x1 * y2 != x2 * y1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
