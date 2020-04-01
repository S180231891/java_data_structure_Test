package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两棵二叉树，编写函数检验他们是否相同
 * 结构相同、数值相同、才能说明该树相同
 */
public class zbg_100
{
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //使用中序遍历判断序列是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        if (p==null || q==null)
            return false;
        List<Integer> a = Minnd(p);
        List<Integer> b = Minnd(q);
        if (a.size()!=b.size())
            return false;
        for (int i=0;i<a.size();i++){
            if (a.get(i)!=b.get(i)){
                return false;
            }

        }
        return true;
    }
    List<Integer> list = new ArrayList<>();
    public List<Integer> Minnd(TreeNode node){
        if (node.left!=null){
            Minnd(node.left);
        }
        if (node.right!=null){
            Minnd(node.right);
        }
        list.add(node.val);
        return list;

    }


    //官方求解；使用递归
    public boolean IsSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        if (p==null || q==null)
            return false;
        if (p.val != q.val) return false;
        return IsSameTree(p.right, q.right) &&
                IsSameTree(p.left, q.left);
    }
}
