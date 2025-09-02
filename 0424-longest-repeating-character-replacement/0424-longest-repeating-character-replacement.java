class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; 
        int right = 0; 
        int maxFreq = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c,0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            if((right - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;     
        }
        return maxLength;
    }
}