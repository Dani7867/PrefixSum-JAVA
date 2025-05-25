/*
 LC:560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
*/

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums  = {1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums,k));
    }
  // O(n)
    private static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>  map = new HashMap<>();
        map.put(0,1);
        int sum = 0 , count = 0;
       for(int  n : nums){
            sum+= n;
            count += map.getOrDefault(sum - k ,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
       return count;
    }

    // O(n^2)
    private static int subarraySum1(int[] nums, int k) {
        int  count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0 ;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k ){
                    count++;
                }
            }
        }
        return count;
    }


}

