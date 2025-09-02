// class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//       List<List<Integer>> result = new ArrayList<>();
//        if(nums.length < 3) return result;
//        Arrays.sort(nums);
//        int n = nums.length;
//        for(int i = 0; i < n-2; i++){
//            if ((i > 0) && (nums[i - 1] == nums[i])) continue;
//            int low = i + 1;
//            int high = n - 1;
//            while (low < high){
//                int sum = nums[i] + nums[low] + nums[high];
//                // case 1 sum = 0 
//                if(sum == 0){
//                    List<Integer> current = Arrays.asList(nums[i],nums[low],nums[high]);
//                    result.add(current);
//                    low++; 
//                 //    high--;
//                    while(low < high && nums[low] == nums[low-1]) low++;
//                 //    while(low < high && nums[high] == nums[high + 1]) high--;
//                } else if (sum < 0){ // case 2 sum < 0
//                    low++;
//                }else { // case 3 sum > 0
//                    high--;
//                }
//            }
//        }
//        return result;
//    }
// }

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                    while (nums[k] == nums[k+1] && j < k) {
                        k--;
                    }
                }
            }
        }
        return res;        
    }
}