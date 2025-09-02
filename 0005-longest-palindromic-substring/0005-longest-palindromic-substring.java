class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (s == null || n == 0) {
            return "";
        }

        int left = 0;
        int right = 0;

        for(int i = 0; i < n; i++) {
            int odd = helper(s, i, i);
            int even = helper(s, i, i + 1);
            int max = Math.max(odd, even);

            if(max > right - left) {
                left = i - (max - 1) / 2;
                right = i + max / 2;
            }
        } 
        return s.substring(left, right + 1);
    }

    private int helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }  
}