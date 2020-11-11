class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        boolean valid = false;
        
        int A[] = new int[6];
        
         A[0] = (p1[0] - p2[0])*(p1[0] - p2[0]) + (p1[1] - p2[1])*(p1[1] - p2[1]); //L12_square
         A[1] = (p1[0] - p3[0])*(p1[0] - p3[0]) + (p1[1] - p3[1])*(p1[1] - p3[1]); // L13_square
         A[2] = (p1[0] - p4[0])*(p1[0] - p4[0]) + (p1[1] - p4[1])*(p1[1] - p4[1]); //L14_square
        
         A[3] = (p3[0] - p4[0])*(p3[0] - p4[0]) + (p3[1] - p4[1])*(p3[1] - p4[1]);  // L34_square
         A[4] = (p3[0] - p2[0])*(p3[0] - p2[0]) + (p3[1] - p2[1])*(p3[1] - p2[1]);  //L23_square
         A[5] = (p4[0] - p2[0])*(p4[0] - p2[0]) + (p4[1] - p2[1])*(p4[1] - p2[1]); //L24_square
       
        Arrays.sort(A); 
        
        if (A[0] == A[1] && A[1] ==A[2] && A[2] ==A[3] && A[4] ==A[5] && A[4]==2*A[3] && A[4] !=0)
            valid = true;
        
        //System.out.println(Arrays.toString(A));
        return valid;
            
        
        
        
    }
}
