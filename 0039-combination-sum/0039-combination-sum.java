class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(0, candidates, target, result, new ArrayList<>());
        return result;
    }
    private void helper(int idx, int[] arr, int target, List<List<Integer>> result, List<Integer> ds) {
        if(idx == arr.length) {
            if(target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[idx] <= target) {
            ds.add(arr[idx]);
            helper(idx, arr, target - arr[idx], result, ds);
            ds.remove(ds.size() - 1);
        }
        helper(idx + 1, arr, target, result, ds);
    }
}