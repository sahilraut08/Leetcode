class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> li = new ArrayList<>();
        int n = height.length;
        for (int i = 1; i < n; i++) {
            if (height[i - 1] > threshold) {
                li.add(i);
            }
        }
        return li;
    }
}