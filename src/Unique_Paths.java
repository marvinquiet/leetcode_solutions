/**
 * Created by wjma on 8/26/16.
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?

 m and n will be at most 100.
 */
public class Unique_Paths {
    // 可以使用dp 也可以使用回溯 也可以考虑总共需要走 m+n-2步, 且横向n-1步, 竖向m-1步, 因此排列组合即可求解
    public int uniquePaths(int m, int n) {
        return backstack(0, 0, n, m);
    }

    private int backstack(int row, int col, int n, int m) {
        if (row == n-1 && col == m-1)
            return 1;
        if (row >= n || col >= m)
            return 0;

        return backstack(row, col+1, n, m) + backstack(row+1, col, n, m);
    }


//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[n][m];
//        for (int j = 0; j < m; j++) dp[0][j] = 1;
//        for (int i = 0; i < n; i++) dp[i][0] = 1;
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[n-1][m-1];
//    }
}
