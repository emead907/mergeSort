import java.util.Comparator;

/**
 * Class for sorting lists that implement the IndexedUnsortedList interface,
 * using ordering defined by class of objects in list or a Comparator.
 * As written uses Merge Sort algorithm.
 *
 * @author CS221
 * @author Emily Mead
 */
public class Sort
{	
	/**
	 * Returns a new list that implements the IndexedUnsortedList interface. 
	 * As configured, uses WrappedDLL. 
	 * Must be changed if using your own IUDoubleLinkedList class. 
	 * 
	 * @return a new list that implements the IndexedUnsortedList interface
	 */
	public static <T> IndexedUnsortedList<T> newList() 
	{
		//replaced with my IUDoubleLinkedList for extra-credit
		return new IUDoubleLinkedList<T>(); 
	}
	
	/**
	 * Sorts a list that implements the IndexedUnsortedList interface 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @see IndexedUnsortedList 
	 */
	public static <T extends Comparable<T>> void sort(IndexedUnsortedList<T> list) 
	{
		mergesort(list);
	}

	/**
	 * Sorts a list that implements the IndexedUnsortedList interface 
	 * using given Comparator.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @param c
	 *            The Comparator used
	 * @see IndexedUnsortedList 
	 */
	public static <T> void sort(IndexedUnsortedList <T> list, Comparator<T> c) 
	{
		mergesort(list, c);
	}
	
	/**
	 * Merge Sort algorithm to sort objects in a list 
	 * that implements the IndexedUnsortedList interface, 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 */
	private static <T extends Comparable<T>> void mergesort(IndexedUnsortedList<T> list)
	{
		
		// sub-lists about half the size of list 
		IndexedUnsortedList<T> lowerList = newList(); 
		IndexedUnsortedList<T> upperList = newList(); 
		
		while(!list.isEmpty())
		{
			lowerList.add(list.first());
			list.removeFirst();
			if(!list.isEmpty())
			{
				upperList.add(list.last());
				list.removeLast();
			}
		}
		if(lowerList.size() != 1 && lowerList.size() != 0)
		{
			mergesort(lowerList);
		}
		if(upperList.size() != 1 && upperList.size() != 0)
		{
			mergesort(upperList);
		}
		
		merge(list, lowerList, upperList); 
	}
	
	/**
	 * Implements merge method for Merge Sort algorithm.  
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 *
	 * @param list - reference to original list that's being sorted, now empty 
	 * @param lowerList - lower half of original list 
	 * @param upperList - upper half of original list 
	 */
	private static <T extends Comparable<T>> void merge(IndexedUnsortedList<T> list, IndexedUnsortedList<T> lowerList, IndexedUnsortedList<T> upperList)
	{
		
		int finalSize = lowerList.size() + upperList.size();
		if(lowerList.size() != 0 && upperList.size() != 0)
		{
			while(list.size() < finalSize)
			{
				if(lowerList.first().compareTo(upperList.first()) <= -1)
				{
					list.add(lowerList.first());
					lowerList.removeFirst();
				}
				else if(lowerList.first().compareTo(upperList.first()) >= 1)
				{

					list.add(upperList.first());
					upperList.removeFirst();
				}
				else //if the two values are =
				{

					list.add(lowerList.first());
					lowerList.removeFirst();

					list.add(upperList.first());
					upperList.removeFirst();
				}
			
				if(lowerList.size() == 0)
				{
					int size = upperList.size();
					for(int i = 0; i < size; i++)
					{
						list.add(upperList.first());
						upperList.removeFirst();
					}
				}
				if(upperList.size() == 0)
				{
					int size = lowerList.size();
					for(int i = 0; i < size; i++)
					{
						list.add(lowerList.first());
						lowerList.removeFirst();
					}
				}
				
			}
//			System.out.print("New List: ");
//			for(int i = 0; i < list.size(); i++)
//			{
//				System.out.print(list.get(i) + ", ");
//			}
//			System.out.println("");
		}
	}
		
	/**
	 * Merge Sort algorithm to sort objects in a list 
	 * that implements the IndexedUnsortedList interface,
	 * using the given Comparator.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @param c
	 *            The Comparator used
	 */
	private static <T> void mergesort(IndexedUnsortedList<T> list, Comparator<T> c)
	{		
		// sub-lists about half the size of list 
		IndexedUnsortedList<T> lowerList = newList(); 
		IndexedUnsortedList<T> upperList = newList(); 
				
		while(!list.isEmpty())
		{
			lowerList.add(list.first());
			list.removeFirst();
			if(!list.isEmpty())
			{
				upperList.add(list.last());
				list.removeLast();
			}
		}
		if(lowerList.size() != 1 && lowerList.size() != 0)
		{
			mergesort(lowerList, c);
		}
		if(upperList.size() != 1 && upperList.size() != 0)
		{
			mergesort(upperList, c);
		}
		
		merge(list, lowerList, upperList, c); 

	}
	
	/**
	 * Implements merge method for Merge Sort algorithm 
	 * @param list - reference to original list that's being sorted, now empty 
	 * @param lowerList - lower half of original list 
	 * @param upperList - upper half of original list 
	 * @param c - Comparator for comparing elements in list
	 */
	private static <T> void merge(IndexedUnsortedList<T> list, IndexedUnsortedList<T> lowerList, IndexedUnsortedList<T> upperList, Comparator<T> c)
	{
		int finalSize = lowerList.size() + upperList.size();
		if(lowerList.size() != 0 && upperList.size() != 0)
		{
			while(list.size() < finalSize)
			{
				if(c.compare(lowerList.first(), upperList.first()) <= -1)
				{
					list.add(lowerList.first());
					lowerList.removeFirst();
				}
				else if(c.compare(lowerList.first(), upperList.first()) >= 1)
				{
					list.add(upperList.first());
					upperList.removeFirst();
				}
				else //if the two values are =
				{
					list.add(lowerList.first());
					lowerList.removeFirst();
					list.add(upperList.first());
					upperList.removeFirst();
				}
				
				if(lowerList.isEmpty())
				{
					int size = upperList.size();
					for(int i = 0; i < size; i++)
					{
						list.add(upperList.first());
						upperList.removeFirst();
					}
				}
				if(upperList.isEmpty())
				{	
					int size = lowerList.size();
					for(int i = 0; i < size; i++)
					{
						list.add(lowerList.first());
						lowerList.removeFirst();
					}
				}
				
			}
	}
	
	}
}
