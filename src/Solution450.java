
public class Solution450 {
    int nKey = 0;

    public TreeNode deleteNode(TreeNode root, int key) {
        this.nKey = key;
        TreeNode virtualNode = new TreeNode(Integer.MAX_VALUE);
        virtualNode.left = root;
        find(root, virtualNode);
        return virtualNode.left;
    }

    private void find(TreeNode current, TreeNode parent) {
        if (current == null) {
            return;
        }
        if (current.val < nKey) {
            find(current.right, current);
        } else if (current.val > nKey) {
            find(current.left, current);
        } else {
            delete(current, parent);
        }
    }

    private void delete(TreeNode current, TreeNode parent) {
        if (current.left != null) {
            while (current.left != null) {
                parent = current;
                current = current.left;
                parent.val = current.val;
            }
            parent.left = current.right;
        } else {
            if (parent.val > current.val) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
    }

    public static void main(String[] args) {

    }
}
