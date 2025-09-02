class Solution {
    public boolean isHappy(int n) {
        // Set<Integer> set = new HashSet<>();
        int slow = getNext(n);
        int fast = getNext(getNext(n));
        while (slow != fast) {
            if(fast == 1) return true;
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }
}