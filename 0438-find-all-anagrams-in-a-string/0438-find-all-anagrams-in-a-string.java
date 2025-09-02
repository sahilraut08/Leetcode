class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        List<Integer> result = new ArrayList<>();

        if(sLen < pLen) return result;

        int[] sMap = new int[26];
        int[] pMap = new int[26];

        for(int i = 0; i < pLen; i++) {
            pMap[p.charAt(i) - 'a']++;
            sMap[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sMap, pMap)) result.add(0);

        for(int i = pLen; i < sLen; i++) {
            int prev = i - pLen;
            sMap[s.charAt(prev) - 'a']--;
            sMap[s.charAt(i) - 'a']++;
            if(Arrays.equals(sMap, pMap)) result.add(prev + 1);
        }

        return result;
    }
}