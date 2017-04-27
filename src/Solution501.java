import java.util.LinkedList;
import java.util.List;

public class Solution501 {
	int count = -1;
	int lastVal = Integer.MAX_VALUE;
	int maxCount = 0;

	List<Integer> list = new LinkedList<Integer>();

	public int[] findMode(TreeNode root) {
		find(root);
		if (count > maxCount) {
			list.clear();
			list.add(lastVal);
		} else if (count == maxCount) {
			list.add(lastVal);
		}

		int[] results = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			results[i] = list.get(i);
		}
		return results;

	}

	private void find(TreeNode root) {
		if (root == null) {
			return;
		}
		find(root.left);
		if (root.val != lastVal) {
			if (count > maxCount) {
				maxCount = count;
				list.clear();
				list.add(lastVal);
			} else if (count == maxCount) {
				list.add(lastVal);
			}
			count = 1;
			lastVal = root.val;
		} else {
			count++;
		}
		find(root.right);
	}

	public static void main(String[] args) {
		Solution501 s = new Solution501();
		TreeNode root = new TreeNode(Integer.MAX_VALUE);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);
		System.out.println(s.findMode(root));

	}
}
