import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

/**
  * A unit test class for Sort class. 
  * 
  * @author CS221
  *
  */
public class SortTests
{
	// named elements for use in tests
	public static final Character A = Character.valueOf('A');
	public static final Character B = Character.valueOf('B');
	public static final Character C = Character.valueOf('C');
	public static final Character D = Character.valueOf('D');
	public static final Character E = Character.valueOf('E');
	public static final Character F = Character.valueOf('F');
	public static final Character G = Character.valueOf('G');
	public static final Character H = Character.valueOf('H');
	public static final Character I = Character.valueOf('I');
	public static final Character J = Character.valueOf('J');
	public static final Character K = Character.valueOf('K');
	public static final Character L = Character.valueOf('L');
	public static final Character M = Character.valueOf('M');
	public static final Character N = Character.valueOf('N');
	public static final Character O = Character.valueOf('O');
	public static final Character P = Character.valueOf('P');
	public static final Character Q = Character.valueOf('Q');
	
	// String of possible characters for random generate 
	private static final Character[] CHARS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P' }; 
	
	// max time for big list to pass tests
	public static final long MAX_TIME = 30000;   // in microseconds 
	// type of implementation using to store objects
	public enum ListType { wrapped, dll };  
	
	//*************** Test Methods ***********************************

	/**
	/**
	 * Tests sort method
	 * @param list - implementation of IndexedUnsortedList interface
	 * @param sortedList - implementation of IndexedUnsortedList interface
	 * @return - boolean value, whether lists are equal after sort
	 */
	public static boolean sort(IndexedUnsortedList<Character> list, IndexedUnsortedList<Character> sortedList) 
	{
		Sort.sort(list);
		return equal(list, sortedList);
	}
	
	/**
	 * Tests sort method with a Comparator 
	 * @param list - implementation of IndexedUnsortedList interface
	 * @param sortedList - implementation of IndexedUnsortedList interface
	 * @param c - Comparator object 
	 * @return - boolean value, whether lists are equal after sort
	 */
	public static boolean sort(IndexedUnsortedList<Character> list, IndexedUnsortedList<Character> sortedList, Comparator<Character> c) 
	{
		Sort.sort(list, c);
		return equal(list, sortedList);
	}

	/**
	 * Tests runtime of sort method: 
	 * 		runs sort and determines whether it runs less than the max time allowed.  
	 * @param list - implementation of IndexedUnsortedList interface
	 * @return - boolean value, whether sort execution time is less than MAX_TIME
	 */
	public static boolean sort(IndexedUnsortedList<Character> list) 
	{
		long startTime = System.currentTimeMillis(); 
		Sort.sort(list);
		long stopTime = System.currentTimeMillis(); 
		long duration = stopTime - startTime;
		 return (duration < MAX_TIME);
	}
	
	/**
	 * Tests runtime of sort method with a Comparator:   
	 * runs sort with Comparator and determines whether it runs less than the max time allowed. 
	 * @param list - implementation of IndexedUnsortedList interface
	 * @param c - Comparator object 
	 * @return - boolean value, whether sort execution time is less than MAX_TIME
	 */
	public static boolean sort(IndexedUnsortedList<Character> list, Comparator<Character> c) 
	{
		long startTime = System.currentTimeMillis(); 
		Sort.sort(list, c);
		long stopTime = System.currentTimeMillis(); 
		long duration = stopTime - startTime;
		return (duration < MAX_TIME);
	}

	//*************** Utility Methods  ***********************************
	
	/**
	 * Compares contents, ordering of lists and returns whether they are the same
	 * @param list1 - implementation of IndexedUnsortedList interface
	 * @param list2 - implementation of IndexedUnsortedList interface
	 * @return same - true if lists contain same objects in same order, false otherwise
	 */
	private static boolean equal(IndexedUnsortedList<Character> list1, IndexedUnsortedList<Character> list2)
	{
		boolean same =true;
		Iterator<Character> itr1 = list1.iterator();
		Iterator<Character> itr2 = list2.iterator();
		
		while(itr1.hasNext() && same)
		{
			if(!itr1.next().equals(itr2.next()))
			{
				same = false; 
			}
		}	
		return same; 
	}
			
	/**
	 * Converts array of Characters to IndexedUnsortedList list with same elements 
	 * @param elements - array of Characters 
	 * @return list - IndexedUnsortedList implementation  
	 */
	public static IndexedUnsortedList<Character> initList(Character[] elements) 
	{
		// Get empty list 
		IndexedUnsortedList<Character> list = Sort.newList();
		// Add elements in array to list 
		for (int i = 0; i < elements.length; i++) 
		{
			list.add(elements[i]);
		}
		return list;
	}
	
	/**
	 * Creates a IndexedUnsortedList list of given size with random Characters. 
	 * @param size - int value  
	 * @return list - IndexedUnsortedList implementation  
	 */
	public static IndexedUnsortedList<Character> initList(int size) 
	{
		// Get empty list 
		IndexedUnsortedList<Character> list = Sort.newList();
		// Add random Characters to list 
		for (int i = 0; i < size; i++) 
		{
			list.add(getRandomAlphaNum());
		}
		return list;
	}
	
	/**
	 * Randomly selects Character from Characters possible in list 
	 * @return - random Character 
	 */
    private static Character getRandomAlphaNum() 
    {
        Random r = new Random();
        // get random index into CHARS array 
        int offset = r.nextInt(CHARS.length);
        return CHARS[offset];
    }
	
}
