package session5_q1;

import java.time.temporal.Temporal;

public class vtran86_session5_q1 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
    }



    private TreeNode commmonRoot (TreeNode root, TreeNode node1, TreeNode node2){
        while (true){
            if (root.val<node1.val && root.val< node2.val){
                root=root.right;
            }else if (root.val>node1.val && root.val> node2.val){
                root=root.left;
            }else {
                return root;
            }
        }
    }

    public int distance (TreeNode root, TreeNode node1, TreeNode node2){
        int count =0;
        root = commmonRoot(root,node1,node2);


        return distanceEachNode(root,node1)+distanceEachNode(root,node2);
    }

    private int distanceEachNode(TreeNode root, TreeNode des){
        TreeNode nextROot;
        if (root.val==des.val){
            return 0;
        }else if (root.val<des.val){
            nextROot=root.right;
        }else {
            nextROot=root.left;
        }
        return 1+distanceEachNode(nextROot,des);
    }
}
