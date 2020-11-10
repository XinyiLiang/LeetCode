class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
      
    int row = A.length;
    int col = A[0].length;
        
    
     int temp=0;
        
        
    for (int i = 0; i < row; i++) {
      for(int j = 0; j < Math.round(col/2); j++) {
            
          temp = A[i][j];
          A[i][j] = A[i][col-j-1];
          A[i][col-j-1] = temp;
      }
        for(int x=0; x< col; x++)
        {
            if ( A[i][x] == 1 )
                A[i][x] = 0;
            else
                A[i][x] =1;
        }
    }
        
        
       return A; 
        
        
        
        
        
        
        
    }
}
