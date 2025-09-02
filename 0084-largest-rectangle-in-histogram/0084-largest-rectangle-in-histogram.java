class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i <= n; i++) {
            int currHeight = (i==n) ? 0 : heights[i];
            while(!st.isEmpty() && currHeight < heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : (i - st.peek() - 1);
                result = Math.max(result, height * width);
            }
            st.push(i);
        }
        return result;
    }
}