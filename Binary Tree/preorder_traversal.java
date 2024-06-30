
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> neww = new ArrayList<>();
        inorder(root, neww);
        return neww;
    }

    public void inorder(TreeNode A, List<Integer> neww) {
        if (A == null) {
            return;
        }
        neww.add(A.val);
        inorder(A.left, neww);
        inorder(A.right, neww);
    }
}