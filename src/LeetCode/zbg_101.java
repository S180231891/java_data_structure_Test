package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，检查其是否镜像对称
 *
 */
public class zbg_101
{
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
