package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        if (root==null){
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<length;i++){
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right!=null){
                    queue.add(curr.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
