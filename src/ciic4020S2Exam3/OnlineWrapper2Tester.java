package ciic4020S2Exam3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OnlineWrapper2Tester {

	OnlineWrapper2.UnaryExpressionTree T_12;
	OnlineWrapper2.UnaryExpressionTree T_3;
	OnlineWrapper2.UnaryExpressionTree T0;
	OnlineWrapper2.UnaryExpressionTree T1;
	OnlineWrapper2.UnaryExpressionTree T10;
	OnlineWrapper2.UnaryExpressionTree T20;
	OnlineWrapper2.UnaryExpressionTree T5;

	
	@Before
	public void setUp() {
		T_12 = new OnlineWrapper2.UnaryExpressionTree(-12);
		T_3 = new OnlineWrapper2.UnaryExpressionTree(-3);
		T0 = new OnlineWrapper2.UnaryExpressionTree(0);
		T1 = new OnlineWrapper2.UnaryExpressionTree(1);
		T10 = new OnlineWrapper2.UnaryExpressionTree(10);
		T20 = new OnlineWrapper2.UnaryExpressionTree(20);
		T5 = new OnlineWrapper2.UnaryExpressionTree(5);
	}
	
	@Test
	public void evaluateSquaredTest() {

		OnlineWrapper2.UnaryExpressionTree TZero 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.SQRD,T0);
		OnlineWrapper2.UnaryExpressionTree TOne 
		= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.SQRD,T1);
		OnlineWrapper2.UnaryExpressionTree TPositive 
		= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.SQRD,T10);
		OnlineWrapper2.UnaryExpressionTree TNegative 
		= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.SQRD,T_12);
		OnlineWrapper2.UnaryExpressionTree TConcatinatedSquared 
		= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.SQRD, TPositive);
		
		
		assertEquals("Failed squared for zero", 0, TZero.evaluate(), 1E-10);
		assertEquals("Failed squared for one", 1, TOne.evaluate(), 1E-10);
		assertEquals("Failed squared for positives", 100, TPositive.evaluate(), 1E-10);
		assertEquals("Failed squared for negatives", 144, TNegative.evaluate(), 1E-10);
		assertEquals("Failed on concatinated squares", 10000, TConcatinatedSquared.evaluate(), 1E-10);
	}

	@Test
	public void evaluateInversionTest() {

		OnlineWrapper2.UnaryExpressionTree TZero 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.INV,T0);
		OnlineWrapper2.UnaryExpressionTree TOne 
		= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.INV,T1);
		OnlineWrapper2.UnaryExpressionTree TPositive 
		= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.INV,T10);
		OnlineWrapper2.UnaryExpressionTree TNegative 
		= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.INV,T_12);
		OnlineWrapper2.UnaryExpressionTree TConcatinatedInverse 
		= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.INV, TPositive);
		
		assertEquals("Failed Inverse for zero", Double.POSITIVE_INFINITY, TZero.evaluate(), 1E-10);
		assertEquals("Failed Inverse for one", 1, TOne.evaluate(), 1E-10);
		assertEquals("Failed Inverse for positives", 0.1, TPositive.evaluate(), 1E-10);
		assertEquals("Failed Inverse for negatives", -0.0833333333, TNegative.evaluate(), 1E-10);
		assertEquals("Failed on concatinated Inverse", 10, TConcatinatedInverse.evaluate(), 1E-10);
	}
	
	@Test
	public void evaluateSquareRootTest() {

		OnlineWrapper2.UnaryExpressionTree TZero 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.SQRT,T0);
		OnlineWrapper2.UnaryExpressionTree TOne 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.SQRT,T1);
		OnlineWrapper2.UnaryExpressionTree TPositive 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.SQRT,T20);
		OnlineWrapper2.UnaryExpressionTree TNegative 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.SQRT,T_12);
		OnlineWrapper2.UnaryExpressionTree TConcatinatedSquareRoot 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.SQRT, TPositive);
		
		assertEquals("Failed Inverse for zero", 0, TZero.evaluate(), 1E-10);
		assertEquals("Failed Inverse for one", 1, TOne.evaluate(), 1E-10);
		assertEquals("Failed Inverse for positives", 4.472135954999, TPositive.evaluate(), 1E-10);
		assertEquals("Failed Inverse for negatives", Double.NaN, TNegative.evaluate(), 1E-10);
		assertEquals("Failed on concatinated Inverse", 2.114742526881, TConcatinatedSquareRoot.evaluate(), 1E-10);
	}
	
	@Test
	public void evaluateExponentialTest() {

		OnlineWrapper2.UnaryExpressionTree TZero 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.EXP,T0);
		OnlineWrapper2.UnaryExpressionTree TOne 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.EXP,T1);
		OnlineWrapper2.UnaryExpressionTree TPositive 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.EXP,T20);
		OnlineWrapper2.UnaryExpressionTree TNegative 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.EXP,T_12);
		OnlineWrapper2.UnaryExpressionTree TConcatinatedSquareRoot 
			= new OnlineWrapper2.UnaryExpressionTree(OnlineWrapper2.ExpressionType.EXP, TPositive);
		
		assertEquals("Failed Exponential for zero", 1, TZero.evaluate(), 1E-10);
		assertEquals("Failed Exponential for one", Math.E, TOne.evaluate(), 1E-10);
		assertEquals("Failed Exponential for positives", 4.851651954097903E8, TPositive.evaluate(), 1E-10);
		assertEquals("Failed Exponential for negatives", 6.14421235332821E-6, TNegative.evaluate(), 1E-10);
		assertEquals("Failed on concatinated Exponential", Double.POSITIVE_INFINITY, TConcatinatedSquareRoot.evaluate(), 1E-10);
	}
}