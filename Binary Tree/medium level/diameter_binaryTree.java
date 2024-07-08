class Solution {
    int diameter;

    public int diameterOfBinaryTree(TreeNode A) {
        diameter = 0;
        depth(A);
        return diameter;
    }

    public int depth(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int lh = depth(A.left);
        int rh = depth(A.right);
        diameter = Math.max(diameter, lh + rh);
        return 1 + Math.max(lh, rh);
    }
}