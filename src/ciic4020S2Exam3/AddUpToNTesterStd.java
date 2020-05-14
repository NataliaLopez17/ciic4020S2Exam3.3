package ciic4020S2Exam3;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AddUpToNTesterStd {
	AddUpToNWrapper.List<Integer> L, result;

	@Before
	public void setUp() throws Exception {
		L = new AddUpToNWrapper.SinglyLinkedList<Integer>();

		for (int i = 1; i < 10; i += 2)
			L.add(i);
	}

	@Test
	public void test0() {
		L.clear();
		result = AddUpToNWrapper.addUpToN(L, 7);
		assertTrue("On empty list L addUpToN(L, 7) fails to return empty list.", result.isEmpty());
	}

	@Test
	public void test1() {
		result = AddUpToNWrapper.addUpToN(L, 7);
		assertTrue("On L = [1, 3, 5, 7, 9] addUpToN(L, 7) fails to return empty list.", result.isEmpty());
	}

	@Test
	public void test2() {
		result = AddUpToNWrapper.addUpToN(L, 4);
		assertTrue("On L = [1, 3, 5, 7, 9] addUpToN(L, 4) fails to return [1, 3].",
				result.size() == 2 && result.firstIndex(3) >= 0 && result.firstIndex(1) >= 0);
	}

}