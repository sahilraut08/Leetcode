class Solution {
    public int racecar(int target) {
        Queue<int []> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(new int[]{0,0,1});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int moves = curr[0];
            int position = curr[1];
            int speed = curr[2];
            if(position == target) return moves;
            if(visited.contains(position+" "+speed)) continue;
            else {
                visited.add(position+" "+speed);
                q.add(new int[]{moves+1, position+speed, speed*2});
                if((position + speed > target && speed > 0) || (position + speed < target && speed < 0)) {
                    if(speed > 0) speed = -1;
                    else speed = 1;
                    q.add(new int[]{moves+1, position, speed});
                } 
            }
        }
        return -1;
    }
}