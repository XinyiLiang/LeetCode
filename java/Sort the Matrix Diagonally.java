/* 
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and 
 * going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from
 * mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
 *
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 *
 * Example:
 * Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 *
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * 1 <= mat[i][j] <= 100
 *
 */
 
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        List<Integer> list = new ArrayList<Integer>();
        
        for( int r =0 ; r< rows; r++ )
        {
            int i = r;
            int j = 0;
            while( i<rows && j< cols)
            {
                list.add(mat[i][j]);
                i++;
                j++;
            }
            
            mat = adjust(mat, r, 0, list);
            list.clear();
        }
        
        for( int c = 0 ; c< cols; c++ )
        {
            int col = c;
            int row = 0;
            while( col<cols && row< rows)
            {
                list.add(mat[row][col]);
                row++;
                col++;
            }
            
            mat = adjust(mat, 0, c, list);
            list.clear();
        }
        
        return mat;
    }
    
    public int[][] adjust(int[][] mat, int r, int j, List<Integer> list)
    {
       Collections.sort(list);
       for (int k=0; k< list.size(); k++)
       {
           mat[r][j] = list.get(k);
           r++;
           j++;
       }
        
        return mat;
    }
    
}
