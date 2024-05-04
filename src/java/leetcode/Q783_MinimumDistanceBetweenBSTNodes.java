package leetcode;

public class Q783_MinimumDistanceBetweenBSTNodes {

    static Integer res = Integer.MAX_VALUE;
    static Integer pre = null;

    public static int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);

        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);

        System.out.println(minDiffInBST(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
