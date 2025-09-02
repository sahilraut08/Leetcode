class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        while(l < r) {
            int curArea = Math.min(height[l], height[r]) * (r - l);
            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
            area = Math.max(curArea, area);
        }
        return area;
    }
}