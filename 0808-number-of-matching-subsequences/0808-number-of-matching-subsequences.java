class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<String, Integer> freqWords = new HashMap<>();
        for(String word : words){
            freqWords.put(word, freqWords.getOrDefault(word, 0) + 1);
        }
        for (String key : freqWords.keySet()) {
            if(isSubsequence(key, s)){
                count += freqWords.get(key);
            }
        }
        return count;
    }

    public boolean isSubsequence(String s, String t){
        if(s.isEmpty()) return true;
        int initialS = 0, initialT = 0;
        int sBound = s.length(), tBound = t.length();

        while (initialS < sBound && initialT < tBound){
            if(s.charAt(initialS) == t.charAt(initialT)){
                initialS++;
            }
            initialT++;
        }
        return initialS == s.length();
    }
}