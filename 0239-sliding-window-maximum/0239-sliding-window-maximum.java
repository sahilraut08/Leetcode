class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));         
        int left = 0;
        int right = k - 1;
        int cnt = 0;
        while(cnt < k) {
            maxHeap.offer(new int[] {nums[cnt], cnt});
            cnt++;
        }
        for(int i = 0; i < n - k + 1; i++) {
            result[i] = maxHeap.peek()[0];
            while(!maxHeap.isEmpty() && nums[left] >= maxHeap.peek()[0] && maxHeap.peek()[1] <= left) maxHeap.poll();
            left++;
            right++;
            if(right < n) maxHeap.offer(new int[] {nums[right], right});
        }
        return result;
    }
}