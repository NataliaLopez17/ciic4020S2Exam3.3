package ciic4020S2Exam3;

public class OnlineWrapper2 {

	public static enum ExpressionType {
		SQRD, INV, SQRT, EXP

	}

	public static interface ExpressionNode {
		public double getValue();
	}

	public static class NumericExpressionNode implements ExpressionNode {

		private double number;

		public NumericExpressionNode(double value) {
			this.number = value;
		}

		public double getValue() {
			return this.number;
		}

	}

	/*
	 * A Unary Expression Tree implements arithmetic unary expressions like 1/x, x2
	 * , or ex. The tree has nodes of type ExpressionNode, which is an ADT specified
	 * with an interface. Each ExpressionNode can be implemented by either:
	 * NumericExpressionNode - a node that represents a number. This type of node is
	 * implemented as a class. This type of node is a leaf. UnaryExpressionNode - a
	 * node that represents the operation of the squaring (x2), inverse (1/x),
	 * square root (x1/2), or exponentiation (ex). This type of node is an internal
	 * node with only one child, where the node represents a given operation, and
	 * the child is of type ExpressionNode . A UnaryExpressionTree holds as a
	 * private field a reference to its root. The tree can be constructed in two
	 * ways:
	 * 
	 * By giving a number - this creates a tree with a root of that is a
	 * NumericExpressionNode By giving an operation, and one UnaryExpressionTree -
	 * this creates a root that is a UnaryExpressionNode. The code below implements
	 * these interfaces and classes.
	 */
	public static class UnaryExpressionNode implements ExpressionNode {
		private ExpressionType expType;
		private ExpressionNode leftChild;

		public UnaryExpressionNode(ExpressionType expType, ExpressionNode leftChild) {
			super();
			this.expType = expType;
			this.leftChild = leftChild;
		}

		@Override
		public double getValue() {
			double result = 0.0;
			if (expType == ExpressionType.SQRD) {
				result = Math.pow(leftChild.getValue(), 2);
			}
			if (expType == ExpressionType.INV) {
				result = 1 / leftChild.getValue();
			}
			if (expType == ExpressionType.SQRT) {
				result = Math.sqrt(leftChild.getValue());
			}
			if (expType == ExpressionType.EXP) {
				result = Math.exp(leftChild.getValue());
			}
			return result;
		}

	}

	public static class UnaryExpressionTree {
		private ExpressionNode root;

		public UnaryExpressionTree(double value) {
			this.root = new NumericExpressionNode(value);
		}

		public UnaryExpressionTree(ExpressionType type, UnaryExpressionTree T1) {
			this.root = new UnaryExpressionNode(type, T1.root);
		}

		public double evaluate() {
			return this.root.getValue();
		}

	}
}
