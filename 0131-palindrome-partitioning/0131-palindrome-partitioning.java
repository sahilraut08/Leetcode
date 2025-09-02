class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(0, s, new ArrayList<>());
        return this.result;
    }
    private void helper(int idx, String s, List<String> path) {
        if(idx == s.length()) {
            this.result.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i + 1));
                helper(i + 1, s, path);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}