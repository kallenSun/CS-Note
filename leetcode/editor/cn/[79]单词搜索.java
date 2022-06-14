package leetcode.editor.cn;

class Solution79 {

    public static void main(String[] args) {
        char[] char1 = {'A', 'B', 'C', 'E'};
        char[] char2 = {'S', 'F', 'C', 'S'};
        char[] char3 = {'A', 'D', 'E', 'E'};

        char[][] board = new char[3][2];

        Solution79 test = new Solution79();
        test.exist(board, "SEE");

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = dfs(board, word, 0, 0, 0, visited);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        if (k == word.length()) {
            return true;
        }

        if (i < 0 || j < 0  || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        if (visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        boolean flag = dfs(board, word, i + 1, j, k + 1, visited) ||
                dfs(board, word, i - 1, j, k + 1, visited) ||
                dfs(board, word, i, j + 1, k + 1, visited) ||
                dfs(board, word, i, j - 1, k + 1, visited);

        visited[i][j] = false;
        return flag;
    }

}
