package ciic4020S2Exam3;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;


public class P4WrapperTestStd {
	
	P4Wrapper.SinglyLinkedList<Integer> L1 ;
	

	//// 
	/// Integer Comparator
	public static class IntegerComparator implements Comparator<Integer> {
		
		public IntegerComparator() {
			
		}

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
		
	}

	@Before
	public void setUp() throws Exception {
		L1 = new P4Wrapper.SinglyLinkedList<>();

		L1.add(2);
		L1.add(20);
		L1.add(39);
		L1.add(90);
		
	}

	public static void print(P4Wrapper.SinglyLinkedList<Integer> L, PrintStream P) {
		P.print("[ ");
			
		for (Integer o: L) {
			P.print(o+ " ");
		}
		
		P.println("]");
		
	}

	
	@Test
	public void test1() {
		System.err.println("**Test 1 List L1: \n");
		print(L1, System.err);
		
		P4Wrapper.BinarySearchTree<Integer, Integer> T = P4Wrapper.sortedListToBST(L1);
		System.err.println("*Test 1 resulting BST: \n");
		T.print(System.err);
		assertEquals("Fails sortedListToBST(L1). Not height balanced.", true, T.isBalanced());
		System.err.println("\n**Passes Test1 \n");

	}

	@Test
	public void test2() {
		L1.clear();
		L1.add(-1);
		L1.add(2);
		L1.add(20);
		L1.add(39);
		L1.add(45);
		L1.add(90);
		L1.add(100);

		System.err.println("**Test 2 List L1: \n");
		print(L1, System.err);
		
		P4Wrapper.BinarySearchTree<Integer, Integer> T = P4Wrapper.sortedListToBST(L1);
		System.err.println("*Test 2 resulting BST: \n");
		T.print(System.err);
		assertEquals("Fails sortedListToBST(L1). Not height balanced.", true, T.isBalanced());
		System.err.println("\n**Passes Test2 \n");

	}


}