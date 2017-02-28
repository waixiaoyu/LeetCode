
public class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        int num = 0;
        if (root == null) {
            return 0;
        }
        if (sum == root.val) {
            num++;
        }
        num += dfs(root.left, sum - root.val);
        num += dfs(root.right, sum - root.val);
        return num;
    }

    public static void main(String[] args) {
        Solution437 s = new Solution437();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);

        System.out.println(s.pathSum(root, 8));
    }
}
