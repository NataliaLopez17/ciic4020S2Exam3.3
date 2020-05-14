package ciic4020S2Exam3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IsSymmetricTesterStd {
	IsSymmetricWrapper.SimpleBinaryTreeImp<String> T0, T1, T2, T3, T4;

	@Before
	public void setUp() throws Exception {
		T0 = new IsSymmetricWrapper.SimpleBinaryTreeImp<String>(null);
		T1 = new IsSymmetricWrapper.SimpleBinaryTreeImp<String>(new IsSymmetricWrapper.BinaryTreeNode<String>("Joe"));
		T2 = new IsSymmetricWrapper.SimpleBinaryTreeImp<String>(new IsSymmetricWrapper.BinaryTreeNode<String>("Ned"), T1, null);
		T3 = new IsSymmetricWrapper.SimpleBinaryTreeImp<String>(new IsSymmetricWrapper.BinaryTreeNode<String>("Jim"), T1,
				new IsSymmetricWrapper.SimpleBinaryTreeImp<String>(new IsSymmetricWrapper.BinaryTreeNode<String>("Ned")));
		T4 = new IsSymmetricWrapper.SimpleBinaryTreeImp<String>(new IsSymmetricWrapper.BinaryTreeNode<String>("Jim"), T1,
				new IsSymmetricWrapper.SimpleBinaryTreeImp<String>(new IsSymmetricWrapper.BinaryTreeNode<String>("Joe")));
	}

	@Test
	public void test0() {
		assertTrue("Fails isSymmetric on an empty tree.", T0.isSymmetric());
	}

	@Test
	public void test1() {
		assertTrue("Fails isSymmetric on a tree with a single node", T1.isSymmetric());
	}

	@Test
	public void test2() {
		assertFalse("Fails isSymmetric on a tree with two nodes.", T2.isSymmetric());
	}

}