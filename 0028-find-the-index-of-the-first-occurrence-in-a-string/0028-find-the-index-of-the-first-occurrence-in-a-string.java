class Solution {
    public int strStr(String haystack, String needle) {
        int nIndex = 0;
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(nIndex)) nIndex++;
            else {
                i = i - nIndex;
                nIndex = 0;
            }
            if(nIndex == needle.length()) return i - nIndex + 1;
        } 
        return -1;
    }
}