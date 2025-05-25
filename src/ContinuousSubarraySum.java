import java.util.HashMap;

/**
 * 523. Continuous Subarray Sum
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 * A good subarray is a subarray where:
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 * Note that:
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = {23,2,6,4,7};
        int k = 6;
        System.out.println(checkSubarraySum(nums,k));
    }

    private static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); // handles case when subarray starts at index 0
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0){
                sum = sum % k;
            }
            if(sum<0){
                sum+=k;
            }
            if (map.containsKey(sum)){
                if(i - map.get(sum) >= 2){
                    return true;
                }
            }else{
                map.put(sum,i);
            }
        }
        return false;
    }


 // tle error O(n^2)
     /*
 class Solution {
     public boolean checkSubarraySum(int[] nums, int k) {
         if (nums.length < 2) return false;
         int[] prefixSum = new int[nums.length + 1];
         prefixSum[0] = 0;
         for (int i = 0; i < nums.length; i++) {
             prefixSum[i + 1] = prefixSum[i] + nums[i];
         }
         // Check all subarrays with length >= 2
         for (int i = 0; i < nums.length; i++) {
             for (int j = i + 1; j < nums.length; j++) { // Ensure length >= 2
                 int subarraySum = prefixSum[j + 1] - prefixSum[i];
                 if (k == 0) {
                     if (subarraySum == 0) return true;
                 } else if (subarraySum % k == 0) {
                     return true;
                 }
             }
         }
         return false;
     }
 }
*/

}

