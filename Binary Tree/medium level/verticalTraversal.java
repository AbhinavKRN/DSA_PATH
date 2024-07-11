import java.util.*;

class Triplet<F, S, T> {
    public final F f;
    public final S s;
    public final T t;

    Triplet(F f, S s, T t) {
        this.f = f;
        this.s = s;
        this.t = t;
    }
}

class Solution {
    List<Triplet<Integer, Integer, Integer>> l = new ArrayList<>();

    public void preorder(TreeNode root, int r, int c) {
        if (root != null) {
            l.add(new Triplet(c, r, root.val));
            preorder(root.left, r + 1, c - 1);
            preorder(root.right, r + 1, c + 1);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        preorder(root, 0, 0);
        Collections.sort(this.l, (t1, t2) -> {
            if (t1.f.equals(t2.f)) {
                if (t1.s.equals(t2.s)) {
                    return t1.t - t2.t;
                } else {
                    return t1.s - t2.s;
                }
            } else {
                return t1.f - t2.f;
            }
        });
        Map<Integer, List<Integer>> hm = new TreeMap<>();
        for (Triplet<Integer, Integer, Integer> tp : l) {
            if (!hm.containsKey(tp.f)) {
                hm.put(tp.f, new ArrayList<>());
            }
            hm.get(tp.f).add(tp.t);
        }
        for (int x : hm.keySet()) {
            res.add(hm.get(x));
        }
        return res;

    }
}