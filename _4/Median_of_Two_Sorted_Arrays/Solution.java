package _4.Median_of_Two_Sorted_Arrays;

import java.util.Arrays;

/**
 * <div class="flex items-start justify-between gap-4"><div class="flex items-start gap-2"><div class="text-title-large font-semibold text-text-primary dark:text-text-primary"><a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/median-of-two-sorted-arrays/">4. Median of Two Sorted Arrays</a><div class="text-body ml-2 inline-flex items-center gap-2 py-1"><div class="inline-flex items-center space-x-2"></div></div></div></div><div class="text-body flex flex-none items-center gap-1 py-1.5 text-text-secondary dark:text-text-secondary">Solved<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14" width="1em" height="1em" fill="currentColor" class="fill-none stroke-current text-message-success dark:text-message-success"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="1.2" d="M12.598 7a5.6 5.6 0 11-3.15-5.037m2.1 1.537l-4.9 4.9-1.4-1.4"></path></svg></div></div>
 *
 * <div><div class="elfjS" data-track-load="description_content"><p>Given two sorted arrays <code>nums1</code> and <code>nums2</code> of size <code>m</code> and <code>n</code> respectively, return <strong>the median</strong> of the two sorted arrays.</p>
 *
 * <p>The overall run time complexity should be <code>O(log (m+n))</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> nums1 = [1,3], nums2 = [2]
 * <strong>Output:</strong> 2.00000
 * <strong>Explanation:</strong> merged array = [1,2,3] and median is 2.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
 * <strong>Output:</strong> 2.50000
 * <strong>Explanation:</strong> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>nums1.length == m</code></li>
 * 	<li><code>nums2.length == n</code></li>
 * 	<li><code>0 &lt;= m &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= n &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
 * 	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
 * </ul>
 * </div></div>
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("result(9.5): " + findMedianAfterMergeTwoSortedArr_binarySearch(new int[]{1, 7, 8, 9, 17}, new int[]{2, 10, 16, 19, 30}));
        System.out.println("result(2.5): " + findMedianAfterMergeTwoSortedArr_binarySearch(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println("result(0.0): " + findMedianAfterMergeTwoSortedArr_binarySearch(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println("result(2.0): " + findMedianAfterMergeTwoSortedArr_binarySearch(new int[]{2}, new int[]{}));
        System.out.println("result(2.5): " + findMedianAfterMergeTwoSortedArr_binarySearch(new int[]{2, 3}, new int[]{}));
        System.out.println("result(4.0): " + findMedianAfterMergeTwoSortedArr_binarySearch(new int[]{}, new int[]{4}));
        System.out.println("result(6.0): " + findMedianAfterMergeTwoSortedArr_binarySearch(new int[]{}, new int[]{4, 8}));
        System.out.println("result(10000.5): " + findMedianAfterMergeTwoSortedArr_binarySearch(new int[]{100001}, new int[]{100000}));
        System.out.println("result(10000.5): " + findMedianAfterMergeTwoSortedArr_binarySearch(new int[]{100000}, new int[]{100001}));
    }


    public static double findMedianAfterMergeTwoSortedArr(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;
        if (nums1.length == 0 && nums2.length == 1) return nums2[0];
        if (nums1.length == 1 && nums2.length == 0) return nums1[0];
        if (nums2.length > 1 && nums1.length == 0) {
            int mid = (nums2.length) / 2;
            return nums2.length % 2 == 0 ? (nums2[mid - 1] + nums2[mid]) / 2.0 : nums2[mid];
        }
        if (nums1.length > 1 && nums2.length == 0) {
            int mid = (nums1.length) / 2;
            return nums1.length % 2 == 0 ? (nums1[mid - 1] + nums1[mid]) / 2.0 : nums1[mid];
        }

        int finalLen = nums1.length + nums2.length;
        int newArrLen = finalLen % 2 == 0 ? (finalLen / 2) + 1 : (int) Math.ceil(finalLen / 2.0);
        int[] mergedArr = new int[newArrLen];
        for (int i = 0, j = 0, k = 0; i < newArrLen; i++) {
            if (j == nums1.length) {
                mergedArr[i] = nums2[k++];
            } else if (k == nums2.length) {
                mergedArr[i] = nums1[j++];
            } else if (nums1[j] <= nums2[k]) {
                mergedArr[i] = nums1[j++];
            } else {
                mergedArr[i] = nums2[k++];
            }
        }
        return finalLen % 2 == 0 ? (mergedArr[newArrLen - 1] + mergedArr[newArrLen - 2]) / 2.0 : mergedArr[newArrLen - 1];
    }

    public static double findMedianAfterMergeTwoSortedArr_BruteForce(int[] nums1, int[] nums2) {
        // Get the sizes of both input arrays.
        int n = nums1.length;
        int m = nums2.length;

        // Merge the arrays into a single sorted array.
        int[] merged = new int[n + m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            merged[k++] = nums1[i];
        }
        for (int i = 0; i < m; i++) {
            merged[k++] = nums2[i];
        }

        // Sort the merged array.
        Arrays.sort(merged);

        // Calculate the total number of elements in the merged array.
        int total = merged.length;

        if (total % 2 == 1) {
            // If the total number of elements is odd, return the middle element as the median.
            return (double) merged[total / 2];
        } else {
            // If the total number of elements is even, calculate the average of the two middle elements as the median.
            int middle1 = merged[total / 2 - 1];
            int middle2 = merged[total / 2];
            return ((double) middle1 + (double) middle2) / 2.0;
        }
    }
    public static double findMedianAfterMergeTwoSortedArr_twoPointer(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
            System.out.println("m1: " + m1 + "\tm2: " + m2);
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            double ans = (double) m1 + (double) m2;
            return ans / 2.0;
        }
    }
    public static double findMedianAfterMergeTwoSortedArr_binarySearch(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;

        // Ensure nums1 is the smaller array for simplicity
        if (n1 > n2)
            return findMedianAfterMergeTwoSortedArr_binarySearch(nums2, nums1);

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2; // Calculate the left partition size
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) >> 1; // Calculate mid index for nums1
            int mid2 = left - mid1; // Calculate mid index for nums2

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            // Determine values of l1, l2, r1, and r2
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                // The partition is correct, we found the median
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {
                // Move towards the left side of nums1
                high = mid1 - 1;
            } else {
                // Move towards the right side of nums1
                low = mid1 + 1;
            }
        }

        return 0; // If the code reaches here, the input arrays were not sorted.
    }
}
