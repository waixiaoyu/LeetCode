
public class Solution404 {
	int nSum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				addLeft(root.left);
			}
			if (root.right != null) {
				addRight(root.right);
			}
		}
		return nSum;
	}

	public void addLeft(TreeNode root) {
		if (root.left != null) {
			addLeft(root.left);
		}
		if (root.right != null) {
			addRight(root.right);
		}
		if (root.left == null && root.right == null) {
			nSum += root.val;
		}
	}

	public void addRight(TreeNode root) {
		if (root.left != null) {
			addLeft(root.left);
		}
		if (root.right != null) {
			addRight(root.right);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}