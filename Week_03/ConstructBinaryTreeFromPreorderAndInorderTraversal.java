import leetcode.editor.cn.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据前序遍历和中序遍历 构建这个二叉树
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    Map<Integer,Integer> index ;
    public TreeNode buildTree(int[] preorder, int[] inorder)  {

        index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i],i);
        }
        return buildTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1);
    }

    private  TreeNode buildTree(int[] preorder, int preorderLeft, int preorderRight, int[] inorder, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight || inorderLeft > inorderRight) {
            return null ;
        }
        int preorderRoot = preorderLeft;
        int inorderRoot = index.get(preorder[preorderRoot]);

        int size_left_inorder = inorderRoot- inorderLeft;
        TreeNode root = new TreeNode(preorder[preorderLeft]);

        root.left = buildTree(preorder,preorderLeft+1,preorderLeft+size_left_inorder,inorder,inorderLeft,inorderRoot-1);

        root.right = buildTree(preorder,preorderLeft+size_left_inorder+1,preorderRight,inorder,inorderRoot+1,inorderRight);

        return  root;
    }
}
