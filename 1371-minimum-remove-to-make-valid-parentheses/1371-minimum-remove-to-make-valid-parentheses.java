class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int openCount = 0;

        for(int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if(ch == '(') {
                openCount++;
            } else if(ch == ')') {
                if(openCount == 0) {
                    chars[i] = '#';
                } else {
                    openCount--;
                }
            }
        }

        for(int i = chars.length - 1; i >= 0 && openCount > 0; i--) {
            if(chars[i] == '(') {
                chars[i] = '#';
                openCount--;
            }
        }

        StringBuilder result = new StringBuilder();
        for(char ch : chars) {
            if(ch != '#') {
                result.append(ch);
            }
        }

        return result.toString();
    }
}