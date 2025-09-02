class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        HashMap<Integer, List<Integer>> freqMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : map.keySet()) {
            int freq = map.get(num);
            min = Math.min(freq, min);
            max = Math.max(freq, max);
            if(!freqMap.containsKey(freq)) freqMap.put(freq, new ArrayList<>());
            freqMap.get(freq).add(num);
        }
        int[] result = new int[k];
        for(int i = max; i >= min && k > 0; i--) {
            List<Integer> li = freqMap.get(i);
            if(li == null) continue;
            for(int j = 0; j < li.size() && k > 0; j++){
                result[k - 1] = li.get(j); 
                k--;
            }
        }
        return result;
    }
}