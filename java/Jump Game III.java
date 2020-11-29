class Solution {
    public boolean canReach(int[] arr, int start) {
      
        int len = arr.length;
        
        List<Integer> list = new ArrayList<>();
        
        list.add(start);
       
        int j=0;
        
        while(j<list.size() )
        {
            System.out.println(list);
            
            if (arr[list.get(j)] == 0)
                return true;
   
            if ( !list.contains(arr[list.get(j)] + list.get(j)) &&  arr[list.get(j)] + list.get(j) < arr.length   )
            list.add(arr[list.get(j)] + list.get(j));
            
            if ( !list.contains(list.get(j) - arr[list.get(j)]) && list.get(j) - arr[list.get(j)]  >=0  )
                list.add(list.get(j) - arr[list.get(j)] );
           
           
            j++;
        }
        
        
                       
       return false;
        
    }
    
}
