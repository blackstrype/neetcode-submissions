class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int left_product = 1;
        for(int i = 0; i < nums.length; i++) {
            output[i] = left_product;
            left_product *= nums[i];
        }
        int right_product = 1;
        for(int j = nums.length - 1; j >= 0; j--) {
            output[j] *= right_product;
            right_product *= nums[j];
        }
        return output;
    }
}  
