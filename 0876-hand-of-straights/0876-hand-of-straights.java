class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        Arrays.sort(hand);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        for (int i = 0; i < hand.length; i++) {
            if (map.get(hand[i]) == 0) {
                continue;
            }
            
            for (int j = 0; j < groupSize; j++) {
                int currCard = hand[i] + j;
                
                if (map.getOrDefault(currCard, 0) == 0) {
                    return false;
                }
                
                map.put(currCard, map.get(currCard) - 1);
            }
        }
        return true;
    }
}