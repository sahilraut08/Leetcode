class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i = 1; i < n; i++) {
            int[] prev = result.get(result.size() - 1);
            if(intervals[i][0] > prev[1]) {
                result.add(intervals[i]);
            } else {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}