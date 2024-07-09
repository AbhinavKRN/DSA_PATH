class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        func(root, max);
        return max[0];
    }

    public int func(TreeNode root, int[] max) {
        if (root == null)
            return 0;
        int lefty = Math.max(0, func(root.left, max));
        int righty = Math.max(0, func(root.right, max));
        max[0] = Math.max(max[0], lefty + righty + root.val);
        return Math.max(lefty, righty) + root.val;
    }
}