class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int left_product = 1;
        int i = 0;
        // Populate output with the product of all elements to the left of i
        for(; i < nums.length; i++) {
            output[i] = left_product;
            left_product *= nums[i];
        }
        int right_product = 1;
        // Populate output with the product of all elements to the right and left of i
        for(--i; i >= 0; i--) {
            output[i] *= right_product;
            right_product *= nums[i];
        }
        return output;
    }
}  
