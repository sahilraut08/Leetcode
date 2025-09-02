/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low = 1;
        int high = mountainArr.length() - 2;
        if(mountainArr.length() < 3) return -1;
        int peakIdx = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);
            int leftVal = mountainArr.get(mid - 1);
            int rightVal = mountainArr.get(mid + 1);
            if((midVal > leftVal) && (midVal > rightVal)){
                peakIdx = mid;
                break;
            } 
            else if((leftVal < midVal) && (midVal < rightVal)) low = mid + 1;
            else high = mid - 1;
        }
        int left = binarySearchLeft(target, mountainArr, 0, peakIdx);
        int right = binarySearchRight(target, mountainArr, peakIdx, mountainArr.length() - 1);
        return (left == -1) ? right : left;
    }

    private int binarySearchLeft(int target, MountainArray mountainArr, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);
            if(midVal == target) return mid;
            else if (midVal < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private int binarySearchRight(int target, MountainArray mountainArr, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);
            if(midVal == target) return mid;
            else if (midVal > target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}