class Solution {
    public int[] rowAndMaximumOnes(int[][] arr) {
        int ans[]=new int[2];
        int max=0;
        for(int i=0;i<arr.length;i++){
            int cnt=0;
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==1) cnt++;
            }
            if(cnt>max){
                max=cnt;
                ans[0]=i;
                ans[1]=cnt;
            }
        }
        return ans;
    }
}