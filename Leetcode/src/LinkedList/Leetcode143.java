package LinkedList;

public class Leetcode143 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode second = slow.next;
        ListNode prev = null;
        while (second!= null){
            ListNode tmp = second.next;
            prev = second;
            second = tmp;
        }

        //Re-assign the pointers to match the pattern
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }

    }
}
