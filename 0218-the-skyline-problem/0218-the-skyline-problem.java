class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> height = new ArrayList<>();
        for(int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        maxHeap.add(0);
        int prevHeight = 0;
        List<List<Integer>> result = new ArrayList<>();
        for(int[] h : height) {
            if(h[1] < 0) maxHeap.add(-h[1]);
            else maxHeap.remove(h[1]);
            int currHeight = maxHeap.peek();
            if(prevHeight != currHeight) {
                result.add(Arrays.asList(h[0], currHeight));
                prevHeight = currHeight;
            }
        }
        return result;
    }
}