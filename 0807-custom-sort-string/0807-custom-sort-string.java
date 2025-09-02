class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        StringBuilder str = new StringBuilder();
        for(int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            int cnt = map.getOrDefault(c,0);
            for(int k=0; k<cnt; k++) {
                str.append(c);
            }
            map.remove(c);
        }
        for(char c : map.keySet()) {
            int cnt = map.get(c);
            for(int k=0; k<cnt; k++) {
                str.append(c);
            }
        }
        return str.toString();
    }
}