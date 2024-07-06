import java.util.*;

class Solution {
    public int maxDepth(TreeNode A) {
        if (A == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cu = q.poll();
                if (cu.left != null) {
                    q.add(cu.left);
                }
                if (cu.right != null) {
                    q.add(cu.right);
                }
            }
            ans++;
        }
        return ans;
    }
}