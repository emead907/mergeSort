import java.util.Comparator;

/**
 * Runs a set of black box tests for Sort class. 
 * @author CS221
 */

public class RunSortTests
{
	// arrays of reverse sorted lists
	public static final Character[] SortedArray_1 = {SortTests.A};
	public static final Character[] SortedArray_2 = {SortTests.A, SortTests.B};
	public static final Character[] SortedArray_2_DupA = {SortTests.A, SortTests.A};
	public static final Character[] SortedArray_3 = {SortTests.A, SortTests.B, SortTests.C};
	public static final Character[] SortedArray_3_DupA = {SortTests.A, SortTests.A, SortTests.B};
	public static final Character[] SortedArray_3_DupB = {SortTests.A, SortTests.B, SortTests.B};
	public static final Character[] SortedArray_4 = {SortTests.A, SortTests.B, SortTests.C, SortTests.D};
	public static final Character[] SortedArray_4_DupC = {SortTests.A, SortTests.B, SortTests.C, SortTests.C};
	public static final Character[] RevSortedArray_2 = {SortTests.B, SortTests.A};
	public static final Character[] RevSortedArray_2_DupA = {SortTests.A, SortTests.A};
	public static final Character[] RevSortedArray_3 = {SortTests.C, SortTests.B, SortTests.A};
	public static final Character[] RevSortedArray_3_DupA = {SortTests.B, SortTests.A, SortTests.A};
	public static final Character[] RevSortedArray_3_DupB = {SortTests.B, SortTests.B, SortTests.A};
	public static final Character[] RevSortedArray_4 = {SortTests.D, SortTests.C, SortTests.B, SortTests.A};
	public static final Character[] RevSortedArray_4_DupC = {SortTests.C, SortTests.C, SortTests.B, SortTests.A};
	
	// arrays of lists
	public static final Character[] EmptyArray = {}; 
	public static final Character[] Array_A = {SortTests.A};
	public static final Character[] Array_AB = {SortTests.A, SortTests.B};
	public static final Character[] Array_BA = {SortTests.B, SortTests.A};
	public static final Character[] Array_AA = {SortTests.A, SortTests.A};
	public static final Character[] Array_ACB = {SortTests.A, SortTests.C, SortTests.B};
	public static final Character[] Array_ABC = {SortTests.A, SortTests.B, SortTests.C};
	public static final Character[] Array_BAC = {SortTests.B, SortTests.A, SortTests.C};
	public static final Character[] Array_BCA = {SortTests.B, SortTests.C, SortTests.A};
	public static final Character[] Array_CAB = {SortTests.C, SortTests.A, SortTests.B};
	public static final Character[] Array_CBA = {SortTests.C, SortTests.B, SortTests.A};
	public static final Character[] Array_AAB = {SortTests.A, SortTests.A, SortTests.B};
	public static final Character[] Array_ABA = {SortTests.A, SortTests.B, SortTests.A};
	public static final Character[] Array_BAA = {SortTests.B, SortTests.A, SortTests.A};
	public static final Character[] Array_ABB = {SortTests.A, SortTests.B, SortTests.B};
	public static final Character[] Array_BAB = {SortTests.B, SortTests.A, SortTests.B};
	public static final Character[] Array_BBA = {SortTests.B, SortTests.B, SortTests.A};
	public static final 	Character[] Array_BDAC = {SortTests.B, SortTests.D, SortTests.A, SortTests.C};
	public static final Character[] Array_CADB = {SortTests.C, SortTests.A, SortTests.D, SortTests.B};
	public static final 	Character[] Array_DCBA = {SortTests.D, SortTests.C, SortTests.B, SortTests.A};
	public static final Character[] Array_ABCC = {SortTests.A, SortTests.B, SortTests.C, SortTests.C};
	public static final Character[] Array_CACB = {SortTests.C, SortTests.A, SortTests.C, SortTests.B};
	public static final Character[] Array_CCBA = {SortTests.C, SortTests.C, SortTests.B, SortTests.A};

	// size of a not so big list 	
	private static final int BIG_SIZE = 20000; 
	
	// list to be sorted
	private static IndexedUnsortedList<Character> list; 
	// comparator for testing, sorts elements in descending order  
	private static Comparator<Character> comparator; 

	// instance variables for tracking test results
	private static int passes = 0;
	private static int failures = 0;
	private static int total = 0;

	/** 
	 * Run tests
	 * @param args - not used in this test suite
	 */
	public static void main(String[] args)
	{
		runTests();
		
		// report final verdict
		printFinalSummary();
	}
	
	/** 
	 * Run tests to confirm required functionality 
	*/
	private static void runTests()
	{	
		// result of running tests 
		boolean result; 
		// comparator for some tests
		comparator = new ReverseComparableComparator<Character>(); 
		
		// Run tests 
		printDescription("Running tests for Sort class:");
		printLine(); 

		// Try to sort an empty list 
		list = SortTests.initList(EmptyArray); 
		result = SortTests.sort(list, SortTests.initList(EmptyArray));  
		printResults("Empty List", result);		
		printNewLine(); 
		
		// 	 Try to sort an empty list using Comparator 
		list = SortTests.initList(EmptyArray); 
		result = SortTests.sort(list, SortTests.initList(EmptyArray), comparator);  
		printResults("Empty List, Comparator", result);		
		printNewLine(); 

		// Sort a list with one element (A) 
		list = SortTests.initList(Array_A); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_1));  
		printResults("[ A ]", result);		
		printNewLine(); 

		// Sort a list with one element (A) using Comparator 
		list = SortTests.initList(Array_A); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_1), comparator);  
		printResults("[ A ], Comparator", result);		
		printNewLine(); 

		// Sort a list with two elements (AB) 
		list = SortTests.initList(Array_AB); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_2));  
		printResults("[ A, B ]", result);		
		printNewLine(); 

		// Sort a list with two elements (AB) in reverse order using Comparator 
		list = SortTests.initList(Array_AB); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_2), comparator);  
		printResults("[ A, B ], reverse order, Comparator", result);		
		printNewLine(); 
 
		// Sort a list with two elements (BA) 
		list = SortTests.initList(Array_BA); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_2));  
		printResults("[ B, A ]", result);		
		printNewLine(); 

		// Sort a list with two elements (BA) in reverse order using Comparator 
		list = SortTests.initList(Array_BA); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_2), comparator);  
		printResults("[ B, A ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a list with two repeated elements (AA) 
		list = SortTests.initList(Array_AA); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_2_DupA));  
		printResults("[ A, A ]", result);		
		printNewLine(); 

		// Sort a list with two repeated elements (AA) using Comparator 
		list = SortTests.initList(Array_AA); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_2_DupA), comparator);  
		printResults("[ A, A ], Comparator", result);		
		printNewLine(); 

		// Sort a list with three elements (ABC) 
		list = SortTests.initList(Array_ABC); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_3));  
		printResults("[ A, B, C ]", result);		
		printNewLine(); 

		// Sort a list with three elements (ABC) in reverse order using Comparator 
		list = SortTests.initList(Array_ABC); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_3), comparator);  
		printResults("[ A, B, C ], reverse order, Comparator", result);		
		printNewLine(); 
		
		// Sort a list with three elements (ACB) 
		list = SortTests.initList(Array_ACB); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_3));  
		printResults("[ A, C, B ]", result);		
		printNewLine(); 

		// Sort a list with three elements (ACB) in reverse order using Comparator 
		list = SortTests.initList(Array_ACB); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_3), comparator);  
		printResults("[ A, C, B ], reverse order, Comparator", result);		
		printNewLine(); 
		
		// Sort a list with three elements (BAC) 
		list = SortTests.initList(Array_BAC);  
		result = SortTests.sort(list, SortTests.initList(SortedArray_3));  
		printResults("[ B, A, C ]", result);		
		printNewLine(); 

		// Sort a list with three elements (BAC) in reverse order using Comparator 
		list = SortTests.initList(Array_BAC); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_3), comparator);  
		printResults("[ B, A, C ], reverse order, Comparator", result);		
		printNewLine(); 
		
		// Sort a list with three elements (BCA) 
		list = SortTests.initList(Array_BCA); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_3));  
		printResults("[ B, C, A ]", result);		
		printNewLine(); 

		// Sort a list with three elements (BCA) in reverse order using Comparator 
		list = SortTests.initList(Array_BCA); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_3), comparator);  
		printResults("[ B, C, A ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a list with three elements (CAB) 
		list = SortTests.initList(Array_CAB); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_3));  
		printResults("[ C, A, B ]", result);		
		printNewLine(); 

		// Sort a list with three elements (CAB) in reverse order using Comparator 
		list = SortTests.initList(Array_CAB); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_3), comparator);  
		printResults("[ C, A, B ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a list with three elements (CBA) 
		list = SortTests.initList(Array_CBA); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_3));  
		printResults("[ C, B, A ]", result);		
		printNewLine(); 

		// Sort a list with three elements (CBA) in reverse order using Comparator 
		list = SortTests.initList(Array_CBA); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_3), comparator);  
		printResults("[ C, B, A ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a list with three elements (AAB) and repeats
		list = SortTests.initList(Array_AAB); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_3_DupA));  
		printResults("[ A, A, B ]", result);		
		printNewLine(); 

		// Sort a list with three elements (AAB) and repeats in reverse order using Comparator 
		list = SortTests.initList(Array_AAB); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_3_DupA), comparator);  
		printResults("[ A, A, B ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a list with three elements (ABA) and repeats
		list = SortTests.initList(Array_ABA); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_3_DupA));  
		printResults("[ A, B, A ]", result);		
		printNewLine(); 

		// Sort a list with three elements (ABA) and repeats in reverse order using Comparator 
		list = SortTests.initList(Array_ABA); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_3_DupA), comparator);  
		printResults("[ A, B, A ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a list with three elements (BAA) and repeats
		list = SortTests.initList(Array_BAA); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_3_DupA));  
		printResults("[ B, A, A ]", result);		
		printNewLine(); 

		// Sort a list with three elements (BAA) and repeats in reverse order using Comparator 
		list = SortTests.initList(Array_BAA); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_3_DupA), comparator);  
		printResults("[ B, A, A ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a list with three elements (BAB) and repeats
		list = SortTests.initList(Array_BAB); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_3_DupB));  
		printResults("[ B, A, B ]", result);		
		printNewLine(); 

		// Sort a list with three elements (BAB) and repeats in reverse order using Comparator 
		list = SortTests.initList(Array_BAB); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_3_DupB), comparator);  
		printResults("[ B, A, B ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a list with four elements (BDAC)
		list = SortTests.initList(Array_BDAC); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_4));  
		printResults("[ B, D, A, C ]", result);		
		printNewLine(); 

		// Sort a list with four elements (BDAC) in reverse order using Comparator 
		list = SortTests.initList(Array_BDAC); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_4), comparator);  
		printResults("[ B, D, A, C ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a list with four elements (CADB)
		list = SortTests.initList(Array_CADB); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_4));  
		printResults("[ C, A, D, B ]", result);		
		printNewLine(); 

		// Sort a list with four elements (CADB) in reverse order using Comparator 
		list = SortTests.initList(Array_CADB); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_4), comparator);  
		printResults("[ C, A, D, B ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a list with four elements (CACB) with repeats
		list = SortTests.initList(Array_CACB); 
		result = SortTests.sort(list, SortTests.initList(SortedArray_4_DupC));  
		printResults("[ C, A, C, B ]", result);		
		printNewLine(); 

		// Sort a list with four elements (CACB) with repeats in reverse order using Comparator 
		list = SortTests.initList(Array_CACB); 
		result = SortTests.sort(list, SortTests.initList(RevSortedArray_4_DupC), comparator);  
		printResults("[ C, A, C, B ], reverse order, Comparator", result);		
		printNewLine(); 

		// Sort a bigish list with randomly generated elements
		list = SortTests.initList(BIG_SIZE); 
		result = SortTests.sort(list);  
		printResults("Big List Timed Sort", result);		
		printNewLine(); 

		// Sort a bigish list with randomly generated elements in reverse order using Comparator 
		list = SortTests.initList(BIG_SIZE); 
		result = SortTests.sort(list, comparator);  
		printResults("Big List Timed, reverse order, Comparator", result);		
		printNewLine(); 

	} 

	/**
	 * Print test results in a consistent format
	 * 
	 * @param testDesc - description of the test
	 * @param result - indicates whether the test passed or failed
	 */	
	public static void printResults(String testDesc, boolean result)
	{
		total++;
		if (result) 
		{
			passes++;
		} 
		else 
		{
			failures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}

	/** 
	 * Print a final summary 
	 */
	private static void printFinalSummary()
	{
		System.out.printf("\nTotal Tests Run: %d,  Passed: %d,  "
				           + "Failed: %d\n", total, passes, failures);
	}
	
	/**
	 * Prints description of tests 
	 * @param description - description of tests 
	 */
	private static void printDescription(String description)
	{
		System.out.println(description);		
	}

	/** 
	 * Prints line between tests
	 */
	private static void printLine()
	{
		System.out.println("=======================================================");
		
	}
	
	/** 
	 * Prints new line between tests
	 */
	private static void printNewLine()
	{
		System.out.println("");		
	}


}
