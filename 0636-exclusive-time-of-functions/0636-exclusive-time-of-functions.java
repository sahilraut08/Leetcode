class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;
        for(String log : logs) {
            String[] logSplit = log.split(":");
            int id = Integer.parseInt(logSplit[0]);
            String process = logSplit[1];
            int currTime = Integer.parseInt(logSplit[2]);
            if(process.equals("start")) {
                if(!st.isEmpty()) {
                    result[st.peek()] += currTime - prevTime;
                }
                st.push(id);
                prevTime = currTime;
            } else {
                result[st.pop()] += currTime - prevTime + 1;
                prevTime = currTime + 1;
            }
        }
        return result;
    }
}