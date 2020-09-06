import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null ) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pollLast();
            output.add(treeNode.val);

            if (treeNode.right != null ) {
                stack.add(treeNode.right);
            }
            if (treeNode.left != null){
                stack.add(treeNode.left);
            }
        }
        return output;
    }
}
