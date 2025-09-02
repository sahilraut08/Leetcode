class Solution {
    public String toGoatLatin(String s) {
        String v="aeiouAEIOU";
        String []arr=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            int idx=v.indexOf(arr[i].charAt(0));
            if(idx!=-1){
                arr[i]+="ma";
            }
            else{
                char c=arr[i].charAt(0);
                arr[i]=arr[i].substring(1,arr[i].length())+c+"ma";
            }
            for(int j=0;j<i+1;j++){
                arr[i]+='a';
            }
            sb.append(arr[i]);
            if(i!=arr.length-1)sb.append(" ");
        }
        return sb.toString();
    }
}