class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        String[] pArr = path.split("/");

        for(String str : pArr) {
            if(!st.isEmpty() && str.equals("..")) 
                st.pop();
            if(!str.equals("") && !str.equals(".") && !str.equals(".."))
                st.push(str);
        }

        // if(st.isEmpty()) return "/";

        // while(!st.isEmpty()) {
        //     res.insert(0, st.pop()).insert(0, "/");
        // }

        // return res.toString();

        return "/" + String.join("/", st);
    }
}