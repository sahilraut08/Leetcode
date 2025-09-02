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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp != null) {
            ListNode kth = findKth(temp, k);
            if(kth == null) {
                if(prev != null) prev.next = temp;
                break;
            }
            ListNode newNode = kth.next;
            kth.next = null;
            reverseList(temp);
            if(temp == head) head = kth;
            else prev.next = kth;
            prev = temp;
            temp = newNode;
        }
        return head;
    }
    public ListNode findKth(ListNode temp, int k) {
        k--;
        while(temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}