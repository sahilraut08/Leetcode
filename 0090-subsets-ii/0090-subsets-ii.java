class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
        
    }
}