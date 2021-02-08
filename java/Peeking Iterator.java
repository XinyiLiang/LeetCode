/* Given an Iterator class interface with methods: next() and hasNext(), 
 * design and implement a PeekingIterator that support the peek() operation  
 *    it essentially peek() at the element that will be returned by the next call to next().
 * 
 * Example:
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2. 
 * You call next() the final time and it returns 3, the last element. 
 * Calling hasNext() after that should return false.
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 *
 * Your input
 * ["PeekingIterator","next","peek","next","next","hasNext"]
 * [[[1,2,3]],[],[],[],[],[]]
 * Expected answer
 * [null,1,2,2,3,false]
 */
 
 
 class PeekingIterator implements Iterator<Integer> {
    
     List<Integer> list = new ArrayList<Integer>();
     int i;
	public PeekingIterator(Iterator<Integer> iterator) {
	  
        while(iterator.hasNext())
        {
            list.add(iterator.next());
        }
        i=0;
        
	}
	
// Returns the next element in the iteration without advancing the iterator.*/
	public Integer peek() {
        return list.get(i);
	}
	
	//hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
  
	@Override
	public Integer next() {
        int nextval = list.get(i);
        i++;
	    return nextval;
	}
	
	@Override
	public boolean hasNext() {
	    return i!=list.size();
	}
}
