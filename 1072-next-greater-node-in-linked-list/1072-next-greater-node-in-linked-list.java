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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n=0;
        while(head!=null){
            n++;
            arr.add(head.val);
            head=head.next;
        }

        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.size()-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr.get(i)){
                st.pop();
            }
            if(st.isEmpty()) {
                result[i]=0;
            } 
            else {
                result[i]=st.peek();
            } 
            st.push(arr.get(i));
        }
        return result;
    };
}