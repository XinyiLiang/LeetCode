class Solution {
    public int longestMountain(int[] A) {
       
        boolean GoingUp = false;
        boolean finished = false;
        boolean GoingDown = false;
        int count=0;
        ArrayList<Integer> MontainLength = new ArrayList<Integer>();
	   
        for (int i = 0 ; i < A.length -1 ; i++)
        {       
            if (GoingUp && A[i]>A[i+1])
            {
                GoingUp = false;
                GoingDown = true;
            }
            
            if ( GoingDown && A[i]>A[i+1]  )
            {
                count++;
            }
            
            if(GoingDown && ( A[i]<=A[i+1] || (i == A.length - 2 && A[i]>A[i+1]) ))
            {
                GoingDown = false;
                finished = true;
                MontainLength.add(count+1);
                count = 0;
            }
            
            if( A[i] == A[i+1])
            {
                GoingUp = false;
                GoingDown = false;
                count=0;
            } 
       
             if (  A[i] < A[i+1] )
            {
                count++;
                GoingUp = true;
            }
            
        }
        
       
        return MontainLength.isEmpty() ? 0 :Collections.max(MontainLength);
       
        
    }
}
