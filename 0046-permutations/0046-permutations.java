class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList<>();
        helper(0, nums);
        return result;
    }
    private void helper(int idx, int[] nums) {
        if(idx == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            this.result.add(new ArrayList<>(ds));
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);
            helper(idx + 1, nums);
            swap(i, idx, nums);
        }
    }
    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}