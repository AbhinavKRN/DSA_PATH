class Solution {
    public boolean isBalanced(TreeNode root) {
        return ss(root) != -1;
    }

    public int ss(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int lh = ss(A.left);
        if (lh == -1) {
            return -1;
        }

        int rh = ss(A.right);
        if (rh == -1) {
            return -1;
        }

        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return Math.max(lh, rh) + 1;
    }
}
