class Solution {
    public String triangleType(int[] nums) {
        if (nums == null || nums.length != 3) {
            return "none";
        }
        int a = nums[0], b = nums[1], c = nums[2];

        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }


        if (a == b && b == c) {
            return "equilateral";
        }
        if (a == b || b == c || c == a) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}