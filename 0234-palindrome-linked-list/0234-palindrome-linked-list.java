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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head; ListNode fast=head;
        if(head==null || head.next==null) return true;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow points towards the middle element
        ListNode head2=slow.next;
        ListNode fast2;
        ListNode temp=null;
        while(head2!=null){
            fast2=head2.next;
            head2.next=temp;
            temp=head2;
            head2=fast2;
        }
        head2=temp;
        slow.next=null;
        //slow2 points to the last val of listnode
        // ListNode slow3=head;
        while(head2!=null){
            if(head.val!=head2.val) return false;
            head=head.next;
            head2=head2.next;
            // System.out.println(head2.val+ " " + head.val);
        }
        return true;
    }
}