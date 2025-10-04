class Solution {
    public int maximumSwap(int num) {
        char[] s = Integer.toString(num).toCharArray();
        int n = s.length;

        int max_digit = '0';
        int max_i = -1;
        int swap_i = -1;
        int swap_j = -1;

        for (int i = n - 1; i >= 0; i--) {
            if(s[i] > max_digit) {
                max_digit = s[i];
                max_i = i;
            }
            if(s[i] < max_digit) {
                swap_i = i;
                swap_j = max_i;
            }
        }

        if (swap_i == -1) return num;
        
        char temp = s[swap_i];
        s[swap_i] = s[swap_j];
        s[swap_j] = temp;

        return Integer.parseInt(new String(s));
    }
}