class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        for(int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while(i < meetings.length) {
            int[] curr = meetings[i];
            while(!pq.isEmpty() && curr[0] >= pq.peek()[1]) {
                freeRooms.offer(pq.poll()[0]);
            }
            if(!freeRooms.isEmpty()) {
                int emptyRoom = freeRooms.poll();
                pq.add(new int[] {emptyRoom, curr[1]});
                map.put(emptyRoom, map.getOrDefault(emptyRoom, 0) + 1);
            } else {
                int[] earliest = pq.poll();
                int room = earliest[0];
                int time = earliest[1];  
                pq.offer(new int[] {room, time + curr[1] - curr[0]});
                // freeRooms.offer(room);
                // while(!pq.isEmpty() && time == pq.peek()[1]) {
                //    int[] same = pq.poll();
                //    freeRooms.offer(same[0]);
                // }
                // int emptyRoom = freeRooms.poll();
                // int newTime = curr[1];
                // if(time > curr[0]) {
                //     newTime += time - curr[0];
                // }
                // pq.add(new int[] {emptyRoom, newTime});
                map.put(room, map.getOrDefault(room, 0) + 1);

            }
            i++;
        }
        int maxValue = Integer.MIN_VALUE;
        int maxKey = Integer.MAX_VALUE;
        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            int room = e.getKey();
            int cnt  = e.getValue();
            if (cnt > maxValue || (cnt == maxValue && room < maxKey)) {
                maxValue = cnt;            
                maxKey   = room;           
            }
        }
        return maxKey;
    }
}