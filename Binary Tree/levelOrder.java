import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode A) {
        List<List<Integer>> neww = new ArrayList<>();
        if (A == null) {
            return neww;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            List<Integer> h = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                h.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            neww.add(h);
        }
        return neww;
    }
}