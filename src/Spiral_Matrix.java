import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjma on 8/23/16.
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class Spiral_Matrix {
    // n * m, 向右 n 步，向下 m－1 步， 向左 n－1 步， 向上 m－2 步
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
        int row = 0, col = -1, n = matrix[0].length, m = matrix.length;
        // 中间发现下一步无路可走的时候，break掉
        while (true) {
            for (int i = 0; i < n; i++) order.add(matrix[row][++col]);
            if (--m == 0) break;
            for (int i = 0; i < m; i++) order.add(matrix[++row][col]);
            if (--n == 0) break;
            for (int i = 0; i < n; i++) order.add(matrix[row][--col]);
            if (--m == 0) break;
            for (int i = 0; i < m; i++) order.add(matrix[--row][col]);
            if (--n == 0) break;
        }

        return order;
    }


    // 方向
//    enum Direction {RIGHT, DOWN, LEFT, UP};
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> order = new ArrayList<Integer>();
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
//        int iBelow = -1, iAbove = matrix.length, jBelow = -1, jAbove = matrix[0].length;
//        int i = 0, j = 0;
//        Direction direction = Direction.RIGHT;
//        while (iBelow < iAbove-1 && jBelow < jAbove-1) {
//            switch (direction){
//                case RIGHT:
//                    j = jBelow+1;
//                    while (j < jAbove) {
//                        order.add(matrix[i][j]);
//                        j++;
//                    }
//                    j = jAbove-1;
//                    iBelow++;
//                    direction = direction.DOWN;
//                    break;
//                case DOWN:
//                    i = iBelow+1;
//                    while (i < iAbove) {
//                        order.add(matrix[i][j]);
//                        i++;
//                    }
//                    i = iAbove-1;
//                    jAbove--;
//                    direction = direction.LEFT;
//                    break;
//                case LEFT:
//                    j = jAbove-1;
//                    while (j > jBelow) {
//                        order.add(matrix[i][j]);
//                        j--;
//                    }
//                    j = jBelow+1;
//                    iAbove--;
//                    direction = direction.UP;
//                    break;
//                case UP:
//                    i = iAbove-1;
//                    while (i > iBelow) {
//                        order.add(matrix[i][j]);
//                        i--;
//                    }
//                    i = iBelow-1;
//                    jBelow++;
//                    direction = direction.RIGHT;
//                    break;
//                default:
//                    break;
//            }
//        }
//        return order;
//    }
}
