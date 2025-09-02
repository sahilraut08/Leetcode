class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, closed = 0, max = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') open++;
            if(s.charAt(i) == ')') closed++;
            if(open == closed) {
                max = Math.max(max, open * 2);
            } else if (closed > open) {
                open = 0;
                closed = 0;
            }
        }
        open = 0;
        closed = 0;
        for(int i = n-1; i >= 0; i--) {
            if(s.charAt(i) == '(') open++;
            if(s.charAt(i) == ')') closed++;
            if(open == closed) {
                max = Math.max(max, open * 2);
            } else if (open > closed) {
                open = 0;
                closed = 0;
            }
        }
        return max;
    }
}