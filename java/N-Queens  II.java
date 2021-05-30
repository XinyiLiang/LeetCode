/* The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:
Input: n = 1
Output: 1

Constraints:
1 <= n <= 9
*/


class Solution {
     
    int solution;
    int Q; 
    public int totalNQueens(int n) {
        
        solution = 0; 
        Q = 1; 
        
        int[][] map = new int[n][n];
        
        nQueens(0,n, map);
        
        return solution;
    }
    
    
    public void nQueens(int y, int n, int[][] map)
    {
        
        if( y == n)
        {
            solution++;
            return;
        } 
        
        for( int x=0; x<n; x++)
        {
            if( map[y][x] !=0 )       continue;
            
            update(x, y, n,map, true);
            
            nQueens(y+1, n, map);
         
            update(x, y, n, map,false); 
            
        }  
         
    }
    

     public void update( int x, int y, int n, int[][] map, boolean place)
    {
        if( place)
        {
             map[y][x] = Q; //place the queen
             Q++;
            
             for(int i = 0; i<n; i++)
                {
                    map[y][i]= map[y][i] == 0 ? Q : map[y][i]; 
                    map[i][x] = map[i][x] == 0 ? Q : map[i][x]; 
                
                    for( int j = 0; j<n; j++)
                    {
                        if(i+j ==x+y || i-j == y-x )
                            map[i][j] = map[i][j] == 0 ? Q : map[i][j];
                    }
                }
            Q++;
           
        }
        else
        {
            map[y][x] =0;
         
            for(int i = 0; i<n; i++)
                {
                    map[y][i]= map[y][i] == Q-1 ? 0 : map[y][i]; 
                    map[i][x] = map[i][x] == Q-1 ? 0 : map[i][x]; 
                
                    for( int j = 0; j<n; j++)
                    {
                        if(i+j ==x+y || i-j == y-x )
                            map[i][j] = map[i][j] == Q-1 ? 0 : map[i][j];
                    }
                }
            
            Q = Q-2;
        }
    }
}
