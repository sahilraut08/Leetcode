class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0) return false;

        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) == 0) {
                continue;
            }
            for (int j = 0; j < k; j++) {
                int currCard = nums[i] + j;
                
                if (map.getOrDefault(currCard, 0) == 0) {
                    return false;
                }
                
                map.put(currCard, map.get(currCard) - 1);
            }
        }
        return true;
    }
}