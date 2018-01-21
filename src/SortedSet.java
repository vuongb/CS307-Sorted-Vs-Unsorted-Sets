// CS307 STUDENTS: PLACE YOUR NAMES ON THE NEXT LINE
// Student name(s): Emil Dides and Bryan Vuong

import java.util.Iterator;
import java.util.ArrayList;

/**
 * In this implementation of the ISet interface the elements in the Set are 
 * maintained in ascending order.
 * The data type for E must be a type that implements Comparable.
 * 
 * Students are to implement methods that were not implemented in AbstractSet and override
 * methods that can be done more efficiently. An ArrayList must be used as the internal storage container.
 * For methods involving two set, if that method can be done more efficiently if the 
 * other set is also a SortedSet do so.
 *
 */
public class SortedSet<E extends Comparable<? super E>> extends AbstractSet<E> {

    private ArrayList<E> myCon;

    /**
     * create an empty SortedSet
     */
    public SortedSet(){
    	myCon = new ArrayList<E>();
    }

    /**
     * create a SortedSet out of an unsorted set. <br>
     * @param other != null, all elements in other implement Comparable
     * and they are mutually comparable
     */
    public SortedSet(ISet<E> other){
    	
    }

    /**
     * Return the smallest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the smallest element in this SortedSet.
     */
    public E first(){
    	if ( myCon.isEmpty()){
    		return null;
    	}
    	return myCon.get(0);
    }

    /**
     * Return the largest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the largest element in this SortedSet.
     */
    public E last(){
    	if ( myCon.isEmpty()){
    		return null;
    	}
    	return myCon.get(myCon.size());
    }
    public E get(int x) {
    	return myCon.get(x);
    }

	public boolean add(E item) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<E> iterator() {
		return myCon.iterator();
	}

	public boolean remove(E item) {
		// TODO Auto-generated method stub
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

	public int size() {
		return myCon.size();
	}

	public ISet<E> union(ISet<E> otherSet) {
		
		ISet<E> result = new SortedSet<E>();
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
		
	}	public ISet<E> difference(ISet<E> otherSet) {
		ISet<E> output = new SortedSet<E>();
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

	public ISet<E> intersection(ISet<E> otherSet) {
		ISet<E> result = new SortedSet<E>();
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
