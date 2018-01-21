// CS307 STUDENTS: PLACE YOUR NAMES ON THE NEXT LINE
// Student name(s): Emil Dides and Bryan Vuong

import java.util.Iterator;

/**
 * Students are to complete this class. 
 * Students should implement as many methods
 * as they can using the Iterator from the iterator 
 * method and the other methods. 
 *
 */
public abstract class AbstractSet<E> implements ISet<E>{
    
	//O(N)
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
                result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0)
            result.setLength(result.length() - seperator.length());

        result.append(")");
        return result.toString();
    }
    
    //O(N^2)
    public boolean equals(Object o){
    	assert this != null;
    	
    	if ( !(o instanceof ISet))
    		return false;
    	return this.containsAll((ISet<E>) o);
      }
    
    //O(N)
    public boolean addAll(ISet<E> items) {
    	boolean result = false;
    	Iterator<E> it = items.iterator();
    	while (it.hasNext())
    	{
    	  if (add(it.next()))
    	   result = true;
    	}
    	return result;
    }
    
    //O(N)
    public void clear() {
	  Iterator<E> it = iterator();
	  while (it.hasNext())
	  {
		  it.next();
		  it.remove();
	  }
	 }

	//O(N)
	public boolean contains(Object object) {
		
	  Iterator<E> it = iterator();
	  if (object != null)
	  {
		  while (it.hasNext())
		  {
			  if (object.equals(it.next()))
				  return true;
		  }
	  } 
	  else {
		  while (it.hasNext())
		  {
			  if (it.next() == null)
				  return true;
		  }
	  }
	  return false;
 }
	
	//O(N^2)
	public boolean containsAll(ISet<E> items) {
		assert items != null;
		Iterator<E> it = items.iterator();
		boolean bool = true;
		while (it.hasNext()) 
		{
			E item = it.next();
			if (!(this.contains(item)))
				bool = false;
		}
		return bool;
	}

	//O(1)
	public boolean isEmpty() {
		return size() == 0;
	}

	// If a Sorted Set Vs. Sorted Set:
	//
	// If a Sorted Set Vs. Unsorted Set:
	//
	// If a Unsorted Set Vs. Unsorted Set
	// O(N)
	public ISet<E> union(ISet<E> items) {
		ISet<E> temp = this.difference(items);
		temp.addAll(this.intersection(items));
		return temp;
	}

	public Iterator<E> iterator() {
		return this.iterator();
	}

}


