class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if(t.length() > n) return "";
        int left = 0; int right = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        while(right < n) {
            char chAtRight = s.charAt(right);
            if(map.containsKey(chAtRight)) {
                map.put(chAtRight, map.get(chAtRight) - 1);
                if(map.get(chAtRight) == 0) count--;
            }
            while(count == 0) {
                if(minLength > right - left + 1) {
                    result = s.substring(left, right + 1);
                    minLength = right - left + 1;
                }
                if(map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0){
                        count++;
                    }
                }
                left++;
            }
            right++;
        }
        return result;
    }
}