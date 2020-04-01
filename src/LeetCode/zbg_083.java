package LeetCode;

/**
 * 删除排序链表中的重复元素,每个元素只出现一次
 *
 */
public class zbg_083
{
    public static void main(String[] args) {

    }
    public  class Node {
        int val;
        Node next;
        Node(int x) { val = x; }
    }
    public Node deleteDuplicates(Node head) {
        if (head==null){
            return null;
        }
        Node temp = head.next;
        Node top = head;
        while (temp!=null){
            if (temp.val != top.val){
                top.next = temp;
                top = temp;
            }
            temp = temp.next;
        }
        top.next = null;
        return head;
    }
}
