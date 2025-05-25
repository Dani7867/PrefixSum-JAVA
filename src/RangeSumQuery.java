// LC - 303. Range Sum Query - Immutable
//Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

public class RangeSumQuery {
    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        Solution s = new Solution(nums);
        int l = 0;
        int r =5;
        System.out.println(s.prefixSum(l,r));
    }
}

class  Solution{
    private int[] prefixSumArray;

    public  Solution(int[] nums){
        prefixSumArray = new int[nums.length];
        prefixSumArray[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            prefixSumArray[i] = prefixSumArray[i-1] + nums[i];
        }
    }
    public int prefixSum(int l , int r){

        if(l == 0) return prefixSumArray[r];

        return  prefixSumArray[r] - prefixSumArray[l-1];
    }
}