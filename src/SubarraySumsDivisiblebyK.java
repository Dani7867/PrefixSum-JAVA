/*
974. Subarray Sums Divisible by K
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum
 divisible by k.
A subarray is a contiguous part of an array.
*/

import java.util.HashMap;

public class SubarraySumsDivisiblebyK {
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(nums,k));
    }
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0 , count = 0 ;
        for(int x : nums){
            sum += x;
            int mod = ((sum % k)+k) % k;
            count += map.getOrDefault(mod,0);
            map.put(mod,map.getOrDefault(mod,0)+1);
        }
        return count;
    }




    // O(n^2) tle
        public static int subarraysDivByK1(int[] nums, int k) {
            int count = 0 ;
            int[] n = new int[nums.length + 1];
            n[0] = nums[0];
            for(int i = 0 ; i<nums.length ; i++){
                n[i + 1] = n[i] + nums[i];
            }
            for(int i = 0 ; i<n.length ; i++){
                for(int j = i+1 ; j<n.length ; j++){
                    if((n[j] - n[i]) % k == 0) count ++;
                }
            }
            return count;
        }
    }

