package LeetCode;
//两数相加
public class zbg_002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(7);
        Solution text = new Solution();
       ListNode result =  text.addTwoNumbers(l1,l2);
       while (true){
           if (result!=null){
               System.out.println(result.val);
           }else
               break;
           result = result.next;
       }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    static class  Solution{
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;//存储进位值
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);//最后一次若还大于0，需再次进位。
            }
            return dummyHead.next;
        }
    }
}
