class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Character> st = new Stack<>();
        for(int i=0; i<num.length(); i++) {
            Character number = num.charAt(i);
            while(k>0 && !st.isEmpty() && number<st.peek()) {
                st.pop();
                k--;
            }
            st.push(number);
        }
        while(k>0){
            st.pop();
            k--;            
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);

        return sb.toString();
    }
}