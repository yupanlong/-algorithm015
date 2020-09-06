import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if ( root == null ) return  new ArrayList<>();
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }

    private List<Integer> helper(TreeNode root, List<Integer> res) {
        if ( root != null ) {
            if ( root.left != null ) {
                helper(root.left ,res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right,res);
            }
        }
        return res;
    }
}
