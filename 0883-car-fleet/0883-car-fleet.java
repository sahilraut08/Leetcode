class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> st = new Stack<>();
        for(int [] car : cars) {
            double pos = car[0];
            double spd = car[1];
            double time = (target - pos) / spd;
            // time = Math.ceil(time);
            if(st.isEmpty() || time > st.peek()) {
                st.push(time);
            } 
        }
        return st.size();
    }
}