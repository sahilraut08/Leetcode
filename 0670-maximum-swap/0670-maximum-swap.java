class Solution {
    public int maximumSwap(int num) {
        char[] s = Integer.toString(num).toCharArray();
        int[] last_idx = new int[10];

        for (int i = 0; i < s.length; i++) 
            last_idx[s[i] - '0'] = i;

        for (int i = 0; i < s.length; i++) {
            for (int d = 9; d > s[i] - '0'; d--) {
                if (last_idx[d] > i) {
                    char temp = s[i];
                    s[i] = s[last_idx[d]];
                    s[last_idx[d]] = temp;
                    return Integer.parseInt(new String(s));
                }
            }
        }
        return num;
    }
}