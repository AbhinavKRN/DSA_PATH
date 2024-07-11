class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false; 
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> levelList = new LinkedList<>(); 
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (zigzag) {
                    levelList.addFirst(node.val);
                } else {
                    levelList.addLast(node.val); 
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(new ArrayList<>(levelList));
            zigzag = !zigzag;
        }
        return ans;
    }
}