package LeetCode;

/**
 * 反转链表
 * 使用递归或迭代的方法将单链表进行反转
 */
public class zbg_206
{
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //使用头插法进行反转
    public ListNode reverseList(ListNode head) {
        if (head.next==null)
            return null;
        ListNode newHead = new ListNode(0);
        ListNode temp =head.next;
        ListNode top = null;
        while (temp!=null){
            top = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = top;
        }
        head.next = newHead.next;



        return head;
    }
}
