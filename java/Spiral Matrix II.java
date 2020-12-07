class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        List<Integer> listminus = new ArrayList<Integer>();
        List<Integer> listadd = new ArrayList<Integer>();
       
        for( int i=1;i<=n-1;i++)
          {
               listadd.add(i);
          }
        for( int i=n-2;i>=0;i--)
          {
               listminus.add(i);
          }
        
        int num = 1;
        int col=0;
        boolean flip = true;
        
        for( int k=n; k>0; k--)
        {
           if(k==n)
           {
               for( int i=0;i<n;i++)
               {
                   matrix[0][i]=num++;
               }
               
           }
           else
           {
              if(flip)
              { 
                  for( int i=0;i<listadd.size();i++)
                  matrix[listadd.get(i)][listadd.get(k-1)]=num++;
            
            
                  for( int i=0;i<listminus.size();i++)
                  matrix[listadd.get(k-1)][listminus.get(i)]=num++;
                  
                  flip=false;
                  listadd.remove(k-1);
                  col = listminus.get(k-1);
                  listminus.remove(k-1);
              }
               else
               {
                   for( int i=0;i<listminus.size();i++)
                     matrix[listminus.get(i)][col]=num++;
                   
                   for( int i=0;i<listadd.size();i++)
                     matrix[col+1][listadd.get(i)]=num++;
                   
                   flip=true;
                   listadd.remove(0);
                   listminus.remove(0);
               }
               
           }
            
            
        }
        
        return matrix;
        
        
    }
}
