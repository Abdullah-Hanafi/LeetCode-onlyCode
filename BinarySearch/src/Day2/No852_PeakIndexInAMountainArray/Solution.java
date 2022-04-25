package Day2.No852_PeakIndexInAMountainArray;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/8 11:45
 */
public class Solution {
//    public int peakIndexInMountainArray(int[] arr) {
//        int index = -1;
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] > arr[i + 1]) {
//                index = i;
//            }
//        }
//        return index;
//    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                index = mid;
                break;
            } else if (arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
