// CS307 STUDENTS: PLACE YOUR NAMES ON THE NEXT LINE
// Student name(s): Emil Dides and Bryan Vuong

import java.util.Iterator;
import java.util.ArrayList;

/**
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */

public class UnsortedSet<E> extends AbstractSet<E> {

	private ArrayList<E> myCon;
	
	public UnsortedSet(){
		myCon = new ArrayList<E>();
	}

	public boolean add(E item) {
		return myCon.add(item);
	}

	//Adds all of the elements in the specified collection to this set if they're not already present. 
	//If the specified collection is also a set, the addAll operation effectively modifies this set so that its value is the union 
	//of the two sets. The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress.
	//Return true if set is altered.
	//O(N^2)
	public boolean addAll(ISet<E> otherSet) {
		
		Iterator <E> it = otherSet.iterator();
		boolean flag = false;
		boolean result = false;
		while(it.hasNext())
		{
			E item = it.next();
			flag = false;
			for (int i = 0; i < myCon.size();i++)
			{
				if (item instanceof Object && item.equals(myCon.get(i)))
					flag = true;
				else if(item == myCon.get(i))
					flag = true;
			}
			if ( flag == false)
				result = true;
			myCon.add(item);
		}
		return result;
	}
	
	
	// O(1)
	public Iterator<E> iterator() {	
		return myCon.iterator();
	}

	// O(N)
	public boolean remove(E item) {
		boolean bool = false;
		for(int i = 0; i < size(); i++)
		{
			if(item instanceof Object && item.equals(myCon.get(i)))
			{
				myCon.remove(i);
				bool = true;
			}
			else if(item == myCon.get(i))
			{
				myCon.remove(i);
				bool = true;
			}
		}
		return bool;
	}

	
	// O(1)
	public int size() {
		return myCon.size();
	}
	
	
	// O(N)
	public ISet<E> union(ISet<E> otherSet) {
		
		ISet<E> result = new UnsortedSet<E>();
		Iterator<E> it = otherSet.iterator();
		for(int i = 0; i < myCon.size(); i++)
		{
			if(!result.contains(myCon.get(i)))
				result.add(myCon.get(i));
		}
		while(it.hasNext())
		{
			E data = it.next();
			if(!result.contains(data))
				result.add(data);
		}
		return result;
		
	}	
	
	// O(N)
	public ISet<E> difference(ISet<E> otherSet) {
		ISet<E> output = new UnsortedSet<E>();
		Iterator<E> it = otherSet.iterator();
		for(int i = 0; i<myCon.size(); i++)
		{
			if(!output.contains(myCon.get(i)) && !otherSet.contains(myCon.get(i)))
				output.add(myCon.get(i));
		}
		while(it.hasNext())
		{
			E data = it.next();
			if(!output.contains(data) && !this.contains(data))
				output.add(data);
		}
		return output;
	}
	
	
	// O(N)
	public ISet<E> intersection(ISet<E> otherSet) {
		ISet<E> result = new UnsortedSet<E>();
		Iterator<E> it = this.iterator();
		while(it.hasNext())
		{
			E data = it.next();
			if(otherSet.contains(data) && !result.contains(data));
				result.add(data);
		}
		return result;
	}

}
