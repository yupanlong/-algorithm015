public class ReverseLinkedList {
    //循环
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null ) {
            ListNode temNode = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = temNode;
        }
        return  prev;
    }
    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next ==null ) return  head;
        ListNode listNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return  listNode;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
