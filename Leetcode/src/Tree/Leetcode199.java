package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        if (root==null){
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            for (int i=0;i<length;i++){
                TreeNode curr = queue.poll();
                ans.add(curr.val);
                if (curr.right!=null){
                    queue.add(curr.right);
                }
            }
        }
        return ans;
    }
}
