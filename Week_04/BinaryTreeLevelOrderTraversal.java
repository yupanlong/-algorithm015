import leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> lev = new ArrayList<>();
            int currQueueSize  = queue.size();  // 这个地方的队列的长度一定要在for循环的外面去写，否则queue 的长度一直在变化，tree的每层的个数就不对了
            for (int i = 1; i <= currQueueSize; i++) {
                TreeNode node = queue.poll();
                lev.add(node.val);
                if (node.left != null ) {
                    queue.offer(node.left);
                }
                if (node.right != null ){
                    queue.offer(node.right);
                }
            }
            res.add(lev);
        }
        return  res;

    }
}
