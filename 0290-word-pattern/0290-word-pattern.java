class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> a = new HashMap<>();
        String[] split_string = s.split(" ",-1);
        if(pattern.length() != split_string.length){
            return false;
        }
            for (int i = 0; i < pattern.length(); i++) {
                if(a.containsKey(pattern.charAt(i))){
                    String n = a.get(pattern.charAt(i));
                    if(!n.equals(split_string[i])){
                        return false;
                    }
                }
                else if(a.containsValue(split_string[i])){
                    return false;
                }
                else{
                    a.put(pattern.charAt(i),split_string[i]);
                }
            }
            
            return true;
    }
}