package Tree;

public class Leetcode1448 {
    public int goodNodes(TreeNode root) {
        return recursive(root,Integer.MIN_VALUE);
    }

    public int recursive(TreeNode root, int max){
        if (root == null){
            return 0;
        }
         int res = root.val >= max ? 1 : 0;
        res+=recursive(root.left,Math.max(root.val,max));
        res+=recursive(root.right,Math.max(root.val, max));
        return res;
    }
}
