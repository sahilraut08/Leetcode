class Solution {
    public int reverse(int x) {
        int number = Math.abs(x);
        int reverse = 0;
        while(number != 0) {
            int rem = number % 10;
            if(reverse > (Integer.MAX_VALUE - rem) / 10) return 0;
            reverse = reverse * 10 + rem;
            number = number / 10;
        }
        if (x < 0) return -reverse;
        return reverse;
    }
}