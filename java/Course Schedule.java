/* LeetCode Challenge - Course Schedule
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */
 
 
 // using Topological Sort via DFS
 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
       int count = 0;
       int[] inDegree = new int[numCourses];
        
        for(int i = 0; i<prerequisites.length; i++)
        {
            inDegree[prerequisites[i][0]]++;    
            
        }
        
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (int i=0; i<inDegree.length;i++)
        {
            if (inDegree[i] ==0)
                stack.push(i);
        }
            
        while(!stack.isEmpty())
        {
            int current = stack.pop();
            //System.out.println(current);
            count++;
                
                for(int i= 0; i<prerequisites.length; i++)
                {
                    if (current == prerequisites[i][1])
                    {  
                        inDegree[prerequisites[i][0]]--;
                       
                        if(inDegree[prerequisites[i][0]] ==0)
                        stack.push(prerequisites[i][0]);
                
                    }
                }
        }
        
        
        return count == numCourses;
        
        
        
    }
}
