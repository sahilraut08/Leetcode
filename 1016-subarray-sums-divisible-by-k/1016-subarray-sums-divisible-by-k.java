class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            int remainder = sum % k;
            if(remainder < 0) remainder += k;
            if(!map.containsKey(remainder)){
                map.put(remainder, 1);
            } else {
                ans += map.get(remainder);
                map.put(remainder, map.get(remainder) + 1);
            }
            
        }
        return ans;
    }
}