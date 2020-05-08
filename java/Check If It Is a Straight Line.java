/*
 *You are given an array coordinates, coordinates[i] = [x, y], where [x, y] 
 *represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 *Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 *Output: true
 *
 *Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 *Output: false
 */

class Solution {
    
    public boolean checkStraightLine(int[][] coordinates) {
        
        int k, b;
        
        //only have two points, then return true
        if (coordinates.length==2 )
            return true;
        
        //more then two poins
        if (coordinates.length>2) 
        {          
            
            for (int i = 2; i < coordinates.length ;i++ )
            {
                  
                if ((coordinates[i][0]-coordinates[0][0])* (coordinates[1][1]-coordinates[0][1]) != (coordinates[1][0]-coordinates[0][0])*(coordinates[i][1]-coordinates[0][1]))
                    return false;
            }
            return true;
        }
        
        
    return false;
    }
}
