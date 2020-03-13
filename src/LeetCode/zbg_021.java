package LeetCode;
//合并两个有序链表
public class zbg_021 {
    public static void main(String[] args) {

    }
    // 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // maintain an unchanging reference to node ahead of the return node.
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // exactly one of l1 and l2 can be non-null at this point, so connect
            // the non-null list to the end of the merged list.
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }

        public ListNode Test(ListNode l1, ListNode l2)
        {
            if (l1 == null) {
                return l2;
            }
            else if (l2 == null) {
                return l1;
            }
            else if (l1.val < l2.val) {
                l1.next = Test(l1.next, l2);
                return l1;
            }
            else {
                l2.next = Test(l1, l2.next);
                return l2;
            }
        }
    }
}