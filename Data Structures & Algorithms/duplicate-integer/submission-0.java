class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
        for(int num : nums) {
            if(checked.containsKey(num)) {
                return true;
            } else {
                checked.put(num, true);
            }
        }
        return false;
    }
}