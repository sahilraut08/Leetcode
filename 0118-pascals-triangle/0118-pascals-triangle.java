class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstValue = new ArrayList<>();
        firstValue.add(1);
        result.add(firstValue);
        for(int i=1; i<numRows; i++) {
            // List<Integer> prevRow= new ArrayList<>();
            // prevRow = result.get(i-1);
            List<Integer> innerRow= new ArrayList<>();
            innerRow.add(1);
            for(int j=1; j<i;j++) {
                innerRow.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            innerRow.add(1);
            result.add(innerRow);
        }
        return result;
    }
}