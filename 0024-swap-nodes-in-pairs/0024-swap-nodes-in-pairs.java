/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;
        ListNode swap1 = dummy;
        ListNode swap2 = dummy;
        while(pointer.next != null && pointer.next.next != null) {
            //setting pointers
            swap1 = pointer.next;
            swap2 = pointer.next.next;

            //swapping
            swap1.next = swap2.next;
            swap2.next = swap1;

            //setting pointer value
            pointer.next = swap2;
            pointer = swap1;

        }

        return dummy.next;
    }
}