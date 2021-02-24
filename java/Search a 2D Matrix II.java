/* Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example 1:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -109 <= target <= 109
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        boolean ans = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int minEdge = Math.min(rows,cols);
      
        for(int i=0; i<minEdge; i++)
        {
            if (matrix[i][i]==target )
            {
                ans = true;
                break;
            }
            else  if(matrix[i][i]>target )
                break;
            else
            {
                
                if(matrix[rows-1][i]>=target)
                {
                    for(int r=i; r<rows; r++)
                    {
                        if(matrix[r][i]==target)
                        {
                            ans = true;
                            break;
                        }
                    }
                }
                if(matrix[i][cols-1]>=target)
                {
                    for(int c=i; c<cols; c++)
                    {
                        if(matrix[i][c]==target)
                        {
                            ans = true;
                            break;
                        }
                    }
                }
                    
            }
        }
        
        return ans;
   }
     
}
