import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null ) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || slow == null ) {
                return false;
            }
            slow = slow.next;  // 每次走一步
            fast = fast.next.next; // 每次走二步
        }
        return true;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        while (head != null ){
            if (hashSet.contains(head)) {
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }
}
