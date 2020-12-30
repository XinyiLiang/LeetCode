class Solution {
     int[] count = new int[2];
   
    public void gameOfLife(int[][] board) {
       
        int[][] original = new int[board.length][board[0].length];
        
         for( int i = 0; i<original.length; i++)
             for(int j=0; j< original[0].length; j++)
               original[i][j]=board[i][j];
            
        
        for( int i = 0; i<original.length; i++)
        {
            for(int j=0; j< original[0].length; j++)
            {
                // top 3
                if( i-1>=0 && j-1>=0)
                {
                    MakeCount(original[i-1][j-1]);
                }
                
                if(i-1>=0 )
                {
                    MakeCount(original[i-1][j]);
                }
                
                 if(i-1>=0 && j+1<original[0].length)
                {
                    MakeCount(original[i-1][j+1]);
                }
                // left beside
                 if(j-1>=0)
                {
                    MakeCount(original[i][j-1]);
                }
                //right beside
                 if(j+1<original[0].length)
                {
                    MakeCount(original[i][j+1]);
                }
                //bottom three
                if( i+1< original.length && j-1>=0)
                {
                    MakeCount(original[i+1][j-1]);
                }
                
                if(i+1< original.length )
                {
                    MakeCount(original[i+1][j]);
                }
                
                 if(i+1< original.length && j+1<original[0].length)
                {
                    MakeCount(original[i+1][j+1]);
                }
                
                if(original[i][j] == 0 && count[1]==3)
                {
                         board[i][j] = 1;
                }
                else if (original[i][j] == 1)
                {
                    if (count[1]>3 || count[1]<2)
                        board[i][j] = 0;
                    
                }
                System.out.println( original[i][j]+"   "+count[0]+"   "+ count[1]);
                count[0]=0;
                count[1]=0;
            }
        }
        
    }
    
    public void MakeCount(int n)
    {
        if (n == 1)
            count[1] = count[1]+1;
        else
            count[0] = count[0]+1;
    }
}
