import java.util.Arrays;
/*
 238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to
 the product of all the elements of nums except nums[i].
*/
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    private static int[] productExceptSelf(int[] nums){
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int r = 1;
        for (int i = nums.length - 1;  i >= 0 ; i--) {
            ans[i] *= r;
            r *= nums[i];
        }
        return ans;
    }

    // space ↑↑
    private static int[] productExceptSelf1(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        for (int i = 0  ; i< nums.length ; i++){
            if(i==0){
                prefix[i] = 1;
                suffix[nums.length-i-1] = 1;
            }else {
                prefix[i] = prefix[i-1] * nums[i-1];
                suffix[nums.length-i-1] = suffix[nums.length-i] * nums[nums.length-i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
    }

    // O(n^2)
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }

        return result;
    }
}
